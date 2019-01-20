package com.jcnc.services.visitor.model.generated;

import java.util.Date;

public class VisitorMessage {
    /**
     *访客留言ID
     */
    private Long messageId;

    /**
     *访客姓名
     */
    private String visitorName;

    /**
     *手机号
     */
    private String mobile;

    /**
     *邮箱
     */
    private String email;

    /**
     *处理人
     */
    private String handleName;

    /**
     *状态(0 未处理, 1 已处理, 2 无需处理)
     */
    private Integer status;

    /**
     *备注
     */
    private String remark;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *更新时间
     */
    private Date updateTime;

    /**
     *留言记录
     */
    private String message;

    /**
     *访客留言ID
     */
    public Long getMessageId() {
        return messageId;
    }

    /**
     *访客留言ID
     */
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    /**
     *访客姓名
     */
    public String getVisitorName() {
        return visitorName;
    }

    /**
     *访客姓名
     */
    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName == null ? null : visitorName.trim();
    }

    /**
     *手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     *手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     *邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     *邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     *处理人
     */
    public String getHandleName() {
        return handleName;
    }

    /**
     *处理人
     */
    public void setHandleName(String handleName) {
        this.handleName = handleName == null ? null : handleName.trim();
    }

    /**
     *状态(0 未处理, 1 已处理, 2 无需处理)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *状态(0 未处理, 1 已处理, 2 无需处理)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     *备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     *创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *留言记录
     */
    public String getMessage() {
        return message;
    }

    /**
     *留言记录
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}