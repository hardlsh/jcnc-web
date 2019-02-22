package com.jcnc.services.product.service;

import com.github.pagehelper.PageInfo;
import com.jcnc.common.param.UserParam;
import com.jcnc.services.product.model.customized.ProductModel;
import com.jcnc.services.product.model.generated.Product;
import com.jcnc.services.resource.model.generated.Image;
import org.springframework.web.multipart.MultipartFile;

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
    Product getProductById(Long productId);

    /**
     * 根据model对象，获取产品
     * @param productModel
     * @return
     */
    List<ProductModel> getProductByModel(ProductModel productModel);

    /**
     * 分页查询所有产品
     * @param param
     * @return
     */
    PageInfo<ProductModel> queryPageProduct(UserParam param);

    /**
     * 新增产品
     * @param product
     */
    void insertProduct(Product product);

    /**
     * 修改产品图片名，图片表插入数据，并保存图片到磁盘
     * @param file
     * @param filename
     * @param fileSize
     * @param productId
     */
    void updateImageBusiness(MultipartFile file, String filename, Double fileSize, Long productId);

    /**
     * 根据主键，修改产品
     * @param product
     */
    void updateProductById(Product product);
}
