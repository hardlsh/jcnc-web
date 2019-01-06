package com.jcnc.common.vo;

/**
 * 自定义响应对象
 *
 * @author shihao.li
 * @date 2018-12-24
 */
public class JCResponse {

    protected String resultCode;

    protected String resultMsg;

    protected Object data;

    /**
     * Creates a new instance of BaseResponse.
     *
     * @param resultCode
     * @param resultMsg
     */
    public JCResponse(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public JCResponse(RetCode code) {
        this.resultCode = code.getCode();
        this.resultMsg = code.getDescription();
    }

    public JCResponse(RetCode code, String resultMsg) {
        this.resultCode = code.getCode();
        this.resultMsg = resultMsg;
    }

    public JCResponse() {
    }

    public void setResult(RetCode code) {
        this.resultCode = code.getCode();
        this.resultMsg = code.getDescription();
    }

    public void setResult(RetCode code, String resultMsg) {
        this.resultCode = code.getCode();
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
