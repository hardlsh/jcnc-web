package com.jcnc.services.product.service.impl;

import com.jcnc.common.service.BaseService;
import com.jcnc.services.product.dao.customized.ProductDao;
import com.jcnc.services.product.model.customized.ProductModel;
import com.jcnc.services.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品服务
 * @author shihao.li
 * @date 2019-1-12
 */
@Service
public class ProductServiceImpl extends BaseService implements ProductService{

    private ProductDao getProductDao() {
        return sqlSession.getMapper(ProductDao.class);
    }

    @Override
    public ProductModel getProductById(Long productId) {
        return getProductDao().getProductById(productId);
    }

    @Override
    public List<ProductModel> getProductByModel(ProductModel productModel) {
        return getProductDao().getProductByModel(productModel);
    }
}
