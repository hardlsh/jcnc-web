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
     *产品类型(0 主打产品, 1 品质产品)
     */
    private Integer productType;

    /**
     *产品图片名称
     */
    private String productImgName;

    /**
     *产品信息
     */
    private String productInfo;

    /**
     *产品详情信息
     */
    private String productDetails;

    /**
     *产品详情图片名称
     */
    private String productDetailsImgName;

    /**
     *顺序
     */
    private Integer sequence;

    /**
     *状态
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
     *产品类型(0 主打产品, 1 品质产品)
     */
    public Integer getProductType() {
        return productType;
    }

    /**
     *产品类型(0 主打产品, 1 品质产品)
     */
    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    /**
     *产品图片名称
     */
    public String getProductImgName() {
        return productImgName;
    }

    /**
     *产品图片名称
     */
    public void setProductImgName(String productImgName) {
        this.productImgName = productImgName == null ? null : productImgName.trim();
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
     *产品详情图片名称
     */
    public String getProductDetailsImgName() {
        return productDetailsImgName;
    }

    /**
     *产品详情图片名称
     */
    public void setProductDetailsImgName(String productDetailsImgName) {
        this.productDetailsImgName = productDetailsImgName == null ? null : productDetailsImgName.trim();
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
     *状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *状态
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