package com.jcnc.services.resource.service;

import com.jcnc.services.resource.model.generated.Image;

/**
 * 图片资源服务
 * @author shihao.li
 * @date 2019-2-20
 */
public interface ImageService {
    /**
     * 根据图片名，查询图片对象
     * @param imageName
     * @return
     */
    Image queryImageByName(String imageName);
    /**
     * 插入图片
     * @param image
     */
    void insertSelective(Image image);

    /**
     * 根据主键，进行修改图片信息
     * @param image
     */
    void updateByPrimaryKeySelective(Image image);
}
