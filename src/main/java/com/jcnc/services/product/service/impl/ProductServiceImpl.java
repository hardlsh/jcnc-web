package com.jcnc.services.product.service.impl;

import com.github.pagehelper.PageInfo;
import com.jcnc.common.param.UserParam;
import com.jcnc.common.service.BaseService;
import com.jcnc.services.product.dao.customized.ProductDao;
import com.jcnc.services.product.model.customized.ProductModel;
import com.jcnc.services.product.model.generated.Product;
import com.jcnc.services.product.service.ProductService;
import com.jcnc.services.resource.model.generated.Image;
import com.jcnc.services.resource.service.ImageService;
import com.jcnc.services.user.model.customized.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 产品服务
 *
 * @author shihao.li
 * @date 2019-1-12
 */
@Service
public class ProductServiceImpl extends BaseService implements ProductService {

    @Autowired
    private ImageService imageService;

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

    @Override
    public PageInfo<ProductModel> queryPageProduct() {
        UserParam param = new UserParam();
        setStartPage(param);
        List<ProductModel> list = getProductDao().queryPageProduct(param);
        PageInfo<ProductModel> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void insertProduct(Product product) {
        Product record = new Product();
        record.setProductName(product.getProductName());
        record.setProductInfo(product.getProductInfo());
        record.setProductDetails(product.getProductDetails());
        getProductDao().insertProduct(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateImageBusiness(Product product, Image image) {
        Image record = imageService.queryImageByName(image.getImageName());
        if (record == null) {
            imageService.insertSelective(image);
        } else {
            image.setImageId(record.getImageId());
            imageService.updateByPrimaryKeySelective(image);
        }
        getProductDao().updateByPrimaryKeySelective(product);
    }

    @Override
    public void updateProductById(Product product) {
        Product record = new Product();
        record.setProductId(product.getProductId());
        record.setProductName(product.getProductName());
        record.setStatus(product.getStatus());
        record.setProductInfo(product.getProductInfo());
        record.setProductDetails(product.getProductDetails());
        getProductDao().updateProductById(record);
    }
}
