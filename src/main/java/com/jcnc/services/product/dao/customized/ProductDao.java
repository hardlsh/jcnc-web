package com.jcnc.services.product.dao.customized;

import com.jcnc.services.product.dao.generated.ProductMapper;
import com.jcnc.services.product.model.customized.ProductModel;

import java.util.List;

/**
 * 产品 Dao类
 * @author shihao.li
 * @date 2019-1-12
 */
public interface ProductDao extends ProductMapper {
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
