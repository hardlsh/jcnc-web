package com.jcnc.controller;

import com.jcnc.common.vo.JCResponse;
import com.jcnc.common.vo.RetCode;
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
            visitorMessageService.saveVisitorMessage(param);
        } catch (Exception e) {
            logger.error("保存访客信息_异常",e);
            return new JCResponse(RetCode.FAILURE);
        }
        return new JCResponse(RetCode.SUCCESS);
    }
}
