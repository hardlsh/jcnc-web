package com.jcnc.services.product.service;

import com.jcnc.services.product.model.customized.ProductModel;

import java.util.List;

/**
 * 产品服务
 * @author shihao.li
 * @date 2019-1-12
 */
public interface ProductService {
    /**
     * 根据产品id，获取产品
     * @param productId
     * @return
     */
    ProductModel getProductById(Long productId);

    /**
     * 根据model对象，获取产品
     * @param productModel
     * @return
     */
    List<ProductModel> getProductByModel(ProductModel productModel);
}