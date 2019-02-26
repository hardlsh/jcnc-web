package com.jcnc.services.resource.model.generated;

import java.util.Date;

public class Dict {
    /**
     *主键ID
     */
    private Long dictId;

    /**
     *字典编号
     */
    private String dictCode;

    /**
     *字典名称
     */
    private String dictName;

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
     *主键ID
     */
    public Long getDictId() {
        return dictId;
    }

    /**
     *主键ID
     */
    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    /**
     *字典编号
     */
    public String getDictCode() {
        return dictCode;
    }

    /**
     *字典编号
     */
    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    /**
     *字典名称
     */
    public String getDictName() {
        return dictName;
    }

    /**
     *字典名称
     */
    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
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