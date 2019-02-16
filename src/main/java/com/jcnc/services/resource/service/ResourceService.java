package com.jcnc.services.resource.service;

import com.jcnc.services.resource.model.customized.ResourceModel;
import com.jcnc.services.resource.vo.ResourceVo;

import java.util.List;

/**
 * 系统资源服务
 * @author shihao.li
 * @date 2019-1-3
 */
public interface ResourceService {
    /**
     * 根据参数,获取组装好的资源
     * @param model
     * @return
     */
    List<ResourceVo> queryPackageResources(ResourceModel model);
    /**
     * 获取组装好的所有资源
     * @return
     */
    List<ResourceVo> queryPackageAllResources();
}
