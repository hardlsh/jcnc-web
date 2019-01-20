package com.jcnc.services.sms;

/**
 * 阿里短信短信模板参数类
 * @author shihao.li
 * @date 2019-1-19
 */
public class TemplateParam {
    /**
     * 访客姓名
     */
    private String visitorName;
    /**
     * 访客手机号码
     */
    private String visitorMobile;
    /**
     * 访客留言信息
     */
    private String visitorMessage;

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorMobile() {
        return visitorMobile;
    }

    public void setVisitorMobile(String visitorMobile) {
        this.visitorMobile = visitorMobile;
    }

    public String getVisitorMessage() {
        return visitorMessage;
    }

    public void setVisitorMessage(String visitorMessage) {
        this.visitorMessage = visitorMessage;
    }
}
