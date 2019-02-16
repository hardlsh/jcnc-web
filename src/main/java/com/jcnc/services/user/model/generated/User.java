package com.jcnc.services.user.model.generated;

import java.util.Date;

public class User {
    /**
     *用户ID
     */
    private Long userId;

    /**
     *登录账号
     */
    private String userName;

    /**
     *密码
     */
    private String password;

    /**
     *姓名
     */
    private String realName;

    /**
     *手机号
     */
    private String phone;

    /**
     *邮箱
     */
    private String email;

    /**
     *用户状态(1-激活, 2-停用)
     */
    private Integer status;

    /**
     *备注
     */
    private String remark;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    /**
     *用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     *用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     *登录账号
     */
    public String getUserName() {
        return userName;
    }

    /**
     *登录账号
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     *密码
     */
    public String getPassword() {
        return password;
    }

    /**
     *密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     *姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     *姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     *手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     *手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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
     *用户状态(1-激活, 2-停用)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *用户状态(1-激活, 2-停用)
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
     *
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}