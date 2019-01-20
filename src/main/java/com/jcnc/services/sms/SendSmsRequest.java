package com.jcnc.services.sms;

import com.aliyuncs.RpcAcsRequest;

/**
 * 发送短信请求对象
 *
 * @author shihao.li
 * @date 2019-1-19
 */
public class SendSmsRequest extends RpcAcsRequest<SendSmsResponse> {

    public SendSmsRequest() {
        super("Dysmsapi", "2017-05-25", "SendSms");
    }

    /**
     * 待发送手机号(单个手机号),必填字段
     */
    private String phoneNumbers;
    /**
     * 短信签名,必填字段
     */
    private String signName;
    /**
     * 短信模板CODE,必填字段
     * 买家新留言！买家：${visitorName}，电话：${visitorMobile}，咨询耐材信息，内容：${visitorMessage}，请尽快联系买家！
     */
    private String templateCode;
    /**
     * 模板中的变量替换JSON串,必填字段
     */
    private String templateParam;

    private String outId;
    private String resourceOwnerAccount;
    private Long resourceOwnerId;
    private Long ownerId;
    private String smsUpExtendCode;


    public String getTemplateCode() {
        return this.templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
        if (templateCode != null) {
            putQueryParameter("TemplateCode", templateCode);
        }
    }

    public String getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        if (phoneNumbers != null) {
            putQueryParameter("PhoneNumbers", phoneNumbers);
        }
    }

    public String getSignName() {
        return this.signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
        if (signName != null) {
            putQueryParameter("SignName", signName);
        }
    }

    public String getResourceOwnerAccount() {
        return this.resourceOwnerAccount;
    }

    public void setResourceOwnerAccount(String resourceOwnerAccount) {
        this.resourceOwnerAccount = resourceOwnerAccount;
        if (resourceOwnerAccount != null) {
            putQueryParameter("ResourceOwnerAccount", resourceOwnerAccount);
        }
    }

    public String getTemplateParam() {
        return this.templateParam;
    }

    public void setTemplateParam(String templateParam) {
        this.templateParam = templateParam;
        if (templateParam != null) {
            putQueryParameter("TemplateParam", templateParam);
        }
    }

    public Long getResourceOwnerId() {
        return this.resourceOwnerId;
    }

    public void setResourceOwnerId(Long resourceOwnerId) {
        this.resourceOwnerId = resourceOwnerId;
        if (resourceOwnerId != null) {
            putQueryParameter("ResourceOwnerId", resourceOwnerId.toString());
        }
    }

    public Long getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
        if (ownerId != null) {
            putQueryParameter("OwnerId", ownerId.toString());
        }
    }

    public String getSmsUpExtendCode() {
        return this.smsUpExtendCode;
    }

    public void setSmsUpExtendCode(String smsUpExtendCode) {
        this.smsUpExtendCode = smsUpExtendCode;
        if (smsUpExtendCode != null) {
            putQueryParameter("SmsUpExtendCode", smsUpExtendCode);
        }
    }

    public String getOutId() {
        return this.outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
        if (outId != null) {
            putQueryParameter("OutId", outId);
        }
    }

    @Override
    public Class<SendSmsResponse> getResponseClass() {
        return SendSmsResponse.class;
    }
}
