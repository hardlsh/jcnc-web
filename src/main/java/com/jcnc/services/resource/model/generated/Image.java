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
     *图片路径
     */
    private String imagePath;

    /**
     *图片大小(kb)
     */
    private Double size;

    /**
     *图片类型(1-产品图片, 2-详情图片)
     */
    private Integer type;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

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
     *图片路径
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     *图片路径
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    /**
     *图片大小(kb)
     */
    public Double getSize() {
        return size;
    }

    /**
     *图片大小(kb)
     */
    public void setSize(Double size) {
        this.size = size;
    }

    /**
     *图片类型(1-产品图片, 2-详情图片)
     */
    public Integer getType() {
        return type;
    }

    /**
     *图片类型(1-产品图片, 2-详情图片)
     */
    public void setType(Integer type) {
        this.type = type;
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