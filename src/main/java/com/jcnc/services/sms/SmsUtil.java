package com.jcnc.services.sms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 阿里短信服务工具类
 *
 * @author shihao.li
 * @date 2019-1-19
 */
public class SmsUtil {

    public static Logger logger = LoggerFactory.getLogger(SmsUtil.class);
    public static Gson gson = new Gson();

    /**
     * 通过阿里云发送短信
     *
     * @param request
     * @return
     * @throws ClientException
     */
    public static SendSmsResponse sendSms(SendSmsRequest request) throws ClientException {
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", SmsConstants.TIME_OUT);
        System.setProperty("sun.net.client.defaultReadTimeout", SmsConstants.TIME_OUT);

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", SmsConstants.ACCESS_KEY_ID, SmsConstants.ACCESS_KEY_SECRET);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", SmsConstants.PRODUCT, SmsConstants.DOMAIN);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        return sendSmsResponse;
    }

    public static void main(String[] args) {
        TemplateParam templateParam = new TemplateParam();
        templateParam.setVisitorName("林家果");
        templateParam.setVisitorMobile("15238317496");
        templateParam.setVisitorMessage("买高铝砖");

        SendSmsRequest request = new SendSmsRequest();
        //组装请求对象-具体描述见控制台-文档部分内容
        //必填:待发送手机号
        request.setPhoneNumbers("13525507576");
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(SmsConstants.SIGN_NAME);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(SmsConstants.TEMPLATE_CODE);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam(gson.toJson(templateParam));
        SendSmsResponse sendSmsResponse;
        try {
            logger.info("[发送短信]请求入参:" + gson.toJson(request));
            sendSmsResponse = sendSms(request);
            logger.info("[发送短信]返回结果:" + gson.toJson(sendSmsResponse));
            if (!SmsConstants.SUCCESS.equals(sendSmsResponse.getCode())) {
                logger.info("[发送短信]失败");
            }
        } catch (Exception e) {
            logger.error("[发送短信]异常,", e);
        }
        logger.info("[发送短信]结束");
    }

}
