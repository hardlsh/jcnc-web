package com.jcnc.controller;

import com.google.gson.Gson;
import com.jcnc.common.vo.JCResponse;
import com.jcnc.common.vo.RetCode;
import com.jcnc.services.sms.*;
import com.jcnc.services.visitor.enums.VisitorMessageStatusEnum;
import com.jcnc.services.visitor.model.customized.VisitorMessageModel;
import com.jcnc.services.visitor.service.VisitorMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 访客留言控制器类
 * @author shihao.li
 * @date 2018-12-24
 */
@Controller
@RequestMapping("visitor")
public class VisitorController {

    private static final Logger logger = LoggerFactory.getLogger(VisitorController.class);

    @Autowired
    private VisitorMessageService visitorMessageService;

    private Gson gson = new Gson();

    /**
     * 保存访客留言信息
     * @param param
     * @return
     */
    @RequestMapping("/saveVisitorMessage")
    @ResponseBody
    public Object saveVisitorMessage (VisitorMessageModel param) {
        try {
            param.setStatus(VisitorMessageStatusEnum.NOT_HANDLE.getKey());
            int result = visitorMessageService.saveVisitorMessage(param);
            if (result == 1) {
                sendSmsHandle(param);
            }
        } catch (Exception e) {
            logger.error("保存访客信息_异常",e);
            return new JCResponse(RetCode.FAILURE);
        }
        return new JCResponse(RetCode.SUCCESS);
    }

    /**
     * 发送短信业务
     * @param param
     */
    private void sendSmsHandle(VisitorMessageModel param) {
        TemplateParam templateParam = new TemplateParam();
        templateParam.setVisitorName(param.getVisitorName());
        templateParam.setVisitorMobile(param.getMobile());
        templateParam.setVisitorMessage(param.getMessage());
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(SmsConstants.TEST_RECEIVE_MOBLIE);
        request.setSignName(SmsConstants.SIGN_NAME);
        request.setTemplateCode(SmsConstants.TEMPLATE_CODE);
        request.setTemplateParam(gson.toJson(templateParam));
        SendSmsResponse sendSmsResponse;
        try {
            logger.info("[发送短信]请求入参:" + gson.toJson(request));
            sendSmsResponse = SmsUtil.sendSms(request);
            logger.info("[发送短信]返回结果:" + gson.toJson(sendSmsResponse));
            if (!SmsConstants.SUCCESS.equals(sendSmsResponse.getCode())) {
                logger.error("[发送短信]失败");
            }
        } catch (Exception e) {
            logger.error("[发送短信]异常,", e);
        }
    }
}
