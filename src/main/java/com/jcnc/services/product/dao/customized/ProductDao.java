package com.jcnc.services.product.dao.customized;

import com.jcnc.common.param.UserParam;
import com.jcnc.services.product.dao.generated.ProductMapper;
import com.jcnc.services.product.model.customized.ProductModel;
import com.jcnc.services.product.model.generated.Product;

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
    Product getProductById(Long productId);

    /**
     * 根据产品名称，获取产品
     * @param productName
     * @return
     */
    Product getProductByName(String productName);

    /**
     * 根据查询参数，查询产品
     * @param param
     * @return
     */
    List<ProductModel> queryProductByParam(UserParam param);

    /**
     * 查询产品对象
     * @param product
     * @return
     */
    List<Product> queryProductList(Product product);

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
