package com.jcnc.services.product.service.impl;

import com.github.pagehelper.PageInfo;
import com.jcnc.common.constant.Constants;
import com.jcnc.common.exception.BusinessException;
import com.jcnc.common.param.UserParam;
import com.jcnc.common.service.BaseService;
import com.jcnc.common.util.CommonUtil;
import com.jcnc.services.product.dao.customized.ProductDao;
import com.jcnc.services.product.model.customized.ProductModel;
import com.jcnc.services.product.model.generated.Product;
import com.jcnc.services.product.service.ProductService;
import com.jcnc.common.enums.ImageTypeEnum;
import com.jcnc.services.resource.model.generated.Image;
import com.jcnc.services.resource.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

/**
 * 产品服务
 *
 * @author shihao.li
 * @date 2019-1-12
 */
@Service
public class ProductServiceImpl extends BaseService implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ImageService imageService;

    private ProductDao getProductDao() {
        return sqlSession.getMapper(ProductDao.class);
    }

    @Override
    public Product getProductById(Long productId) {
        return getProductDao().getProductById(productId);
    }

    @Override
    public Product getProductByName(String productName) {
        return getProductDao().getProductByName(productName);
    }

    @Override
    public PageInfo<ProductModel> queryPageProductByParam(UserParam param) {
        setStartPage(param);
        List<ProductModel> list = getProductDao().queryProductByParam(param);
        PageInfo<ProductModel> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Product> queryProductList(Product product) {
        return getProductDao().queryProductList(product);
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
    public void updateImageBusiness(MultipartFile file, String filename, Double fileSize, Long productId, Integer type) {
        Image image = imageService.queryImageByName(filename);
        if (image == null) {
            image = new Image();
        }
        image.setImageName(filename);
        image.setSize(CommonUtil.getFileSize(file.getSize()));
        image.setImagePath(Constants.MY_IMAGE_PATH + filename);
        image.setType(type);
        if (image.getImageId() != null) {
            imageService.updateByPrimaryKeySelective(image);
        } else {
            imageService.insertSelective(image);
        }
        Product product = new Product();
        product.setProductId(productId);
        if (type.equals(ImageTypeEnum.PRODUCT_IMG.getKey())) {
            product.setImageName(filename);
        } else if (type.equals(ImageTypeEnum.PRODCUT_DETAIL_IMG.getKey())) {
            product.setDetailsImageName(filename);
        }
        this.updateProductById(product);
        try {
            File fileMkdir = new File(Constants.MY_IMAGE_PATH);
            if (!fileMkdir.exists()) {
                fileMkdir.mkdir();
            }
            //定义输出流 将文件保存在本地磁盘
            filename = fileMkdir.getPath()+"\\"+filename;
            // append 默认为false，false为覆盖
            FileOutputStream outputStream = new FileOutputStream(filename, false);
            BufferedOutputStream out = new BufferedOutputStream(outputStream);
            // 写入文件
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (IOException e) {
            logger.error("【产品服务】保存图片异常,", e);
            throw new BusinessException("保存图片异常");
        }
    }

    @Override
    public void updateProductById(Product product) {
        getProductDao().updateByPrimaryKeySelective(product);
    }
}
