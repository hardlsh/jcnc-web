package com.jcnc.common.vo;

import java.io.Serializable;

/**
 * 自定义响应码
 *
 * @author shihao.li
 * @date 2018-12-24
 */
public enum RetCode implements Serializable {
    /**
     * 操作成功
     **/
    SUCCESS("0000", "操作成功"),
    /**
     * 操作失败
     **/
    FAILURE("9999", "操作失败"),
    /**
     * 输入参数不合法
     **/
    INVALID_ARGS("1001", "输入参数格式非法"),
    /**
     * 系统异常
     **/
    SYSTEM_ERROR("1002", "系统异常"),
    /**
     * 图片重名
     */
    IMG_DUPLICATE_NAME("2001", "图片重名"),
    /**
     * 图片相同
     */
    IMG_SAME("2002", "图片相同");

    private String description;

    private String code;

    RetCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 该返回码所对应的返回信息。
     *
     * @return 返回信息
     */
    public String getDescription() {
        return description;
    }

    /**
     * 该返回码所对应的数字码。
     *
     * @return 返回的数字表示
     */
    public String getCode() {
        return code;
    }
}
