package com.jcnc.services.sms;

import com.aliyuncs.AcsResponse;
import com.aliyuncs.transform.UnmarshallerContext;

/**
 * 发送短信返回对象
 * @author shihao.li
 * @date 2019-1-19
 */
public class SendSmsResponse extends AcsResponse {

    /**
     * 请求id
     */
    private String requestId;
    /**
     * 流水id
     */
    private String bizId;
    /**
     * 返回code码  成功码：OK
     */
    private String code;
    /**
     * 返回信息
     */
    private String message;

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getBizId() {
        return this.bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public SendSmsResponse getInstance(UnmarshallerContext context) {
        return SendSmsResponseUnmarshaller.unmarshall(this, context);
    }
}
