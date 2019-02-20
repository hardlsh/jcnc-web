package com.jcnc.services.resource.service.impl;

import com.jcnc.common.service.BaseService;
import com.jcnc.services.resource.dao.customized.ImageDao;
import com.jcnc.services.resource.model.generated.Image;
import com.jcnc.services.resource.service.ImageService;
import org.springframework.stereotype.Service;

/**
 * 图片资源服务
 * @author shihao.li
 * @date 2019-2-20
 */
@Service
public class ImageServiceImpl extends BaseService implements ImageService{

    private ImageDao getImageDao() {
        return sqlSession.getMapper(ImageDao.class);
    }

    @Override
    public Image queryImageByName(String imageName) {
        return getImageDao().queryImageByName(imageName);
    }

    @Override
    public void insertSelective(Image image) {
        getImageDao().insertSelective(image);
    }

    @Override
    public void updateByPrimaryKeySelective(Image image) {
        getImageDao().updateByPrimaryKeySelective(image);
    }
}
