package com.jcnc.common.param;

/**
 * 用户管理查询类
 * @author shihao.li
 * @date 2019-2-17
 */
public class UserParam extends BaseQuery{
    /**
     *产品名称
     */
    private String productName;
    /**
     *状态 0-不可用 1-可用
     */
    private Integer status;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
