package com.jcnc.services.resource.model.generated;

import java.util.Date;

public class DictItem {
    /**
     *字典明细ID
     */
    private Long itemId;

    /**
     *字典编号
     */
    private String dictCode;

    /**
     *字典明细编号
     */
    private String itemCode;

    /**
     *字典明细名称
     */
    private String itemName;

    /**
     *顺序
     */
    private Integer sequence;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    /**
     *字典明细ID
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     *字典明细ID
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
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
     *字典明细编号
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     *字典明细编号
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    /**
     *字典明细名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     *字典明细名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     *顺序
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     *顺序
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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