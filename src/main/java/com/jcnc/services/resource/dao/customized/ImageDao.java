package com.jcnc.services.resource.dao.customized;

import com.jcnc.services.resource.dao.generated.ImageMapper;
import com.jcnc.services.resource.model.generated.Image;

/**
 * 图片资源 Dao类
 * @author shihao.li
 * @date 2019-2-20
 */
public interface ImageDao extends ImageMapper {
    /**
     * 根据图片名，查询图片对象
     * @param imageName
     * @return
     */
    Image queryImageByName(String imageName);
}
