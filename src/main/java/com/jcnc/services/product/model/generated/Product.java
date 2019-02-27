package com.jcnc.services.product.model.generated;

import java.util.Date;

public class Product {
    /**
     *产品ID
     */
    private Long productId;

    /**
     *产品名称
     */
    private String productName;

    /**
     *产品类型(对应一级菜单)
     */
    private Long productType;

    /**
     *图片名称
     */
    private String imageName;

    /**
     *产品信息
     */
    private String productInfo;

    /**
     *产品详情信息
     */
    private String productDetails;

    /**
     *详情图片名称
     */
    private String detailsImageName;

    /**
     *顺序
     */
    private Integer sequence;

    /**
     *状态 0-不可用 1-可用
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
     *产品ID
     */
    public Long getProductId() {
        return productId;
    }

    /**
     *产品ID
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     *产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     *产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     *产品类型(对应一级菜单)
     */
    public Long getProductType() {
        return productType;
    }

    /**
     *产品类型(对应一级菜单)
     */
    public void setProductType(Long productType) {
        this.productType = productType;
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
     *产品信息
     */
    public String getProductInfo() {
        return productInfo;
    }

    /**
     *产品信息
     */
    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo == null ? null : productInfo.trim();
    }

    /**
     *产品详情信息
     */
    public String getProductDetails() {
        return productDetails;
    }

    /**
     *产品详情信息
     */
    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails == null ? null : productDetails.trim();
    }

    /**
     *详情图片名称
     */
    public String getDetailsImageName() {
        return detailsImageName;
    }

    /**
     *详情图片名称
     */
    public void setDetailsImageName(String detailsImageName) {
        this.detailsImageName = detailsImageName == null ? null : detailsImageName.trim();
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
     *状态 0-不可用 1-可用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *状态 0-不可用 1-可用
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