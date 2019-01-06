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
     * 根据参数,获取组装好的用户菜单资源
     * @param model
     * @return
     */
    List<ResourceVo> queryPackageMenuUserResources(ResourceModel model);
}
