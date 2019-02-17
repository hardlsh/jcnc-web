package com.jcnc.services.product.service;

import com.github.pagehelper.PageInfo;
import com.jcnc.common.param.UserParam;
import com.jcnc.services.product.model.customized.ProductModel;
import com.jcnc.services.product.model.generated.Product;

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

    /**
     * 分页查询所有产品
     * @return
     */
    PageInfo<ProductModel> queryPageProduct();

    /**
     * 新增产品
     * @param product
     */
    void insertProduct(Product product);

    /**
     * 根据主键，修改产品
     * @param product
     */
    void updateProductById(Product product);
}
