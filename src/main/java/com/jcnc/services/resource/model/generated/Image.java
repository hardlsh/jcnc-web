package com.jcnc.services.resource.model.generated;

import java.util.Date;

public class Image {
    /**
     *图片ID
     */
    private Long imageId;

    /**
     *图片名称
     */
    private String imageName;

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
     *图片
     */
    private byte[] image;

    /**
     *图片ID
     */
    public Long getImageId() {
        return imageId;
    }

    /**
     *图片ID
     */
    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    /**
     *图片名称
     */
    public String getImageName() {
        return imageName;
    }

    /**
     *图片名称
     */
    public void setImageName(String imageName) {
        this.imageName = imageName == null ? null : imageName.trim();
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

    /**
     *图片
     */
    public byte[] getImage() {
        return image;
    }

    /**
     *图片
     */
    public void setImage(byte[] image) {
        this.image = image;
    }
}