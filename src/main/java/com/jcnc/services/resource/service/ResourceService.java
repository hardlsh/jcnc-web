package com.jcnc.services.resource.service;

import com.jcnc.services.resource.model.customized.ResourceModel;
import com.jcnc.services.resource.model.generated.Resource;
import com.jcnc.services.resource.model.generated.ResourceExample;
import com.jcnc.services.resource.vo.ResourceVo;

import java.util.List;

/**
 * 系统资源服务
 * @author shihao.li
 * @date 2019-1-3
 */
public interface ResourceService {
    /**
     * 根据资源id，获取资源
     * @param resourceId
     * @return
     */
    Resource getResourceById(Long resourceId);
    /**
     * 根据资源名称，获取资源
     * @param resourceName
     * @return
     */
    Resource getResourceByName(String resourceName);
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
    /**
     * 单表查询所有资源
     * @param resource
     * @return
     */
    List<Resource> queryResourceByExample(Resource resource);
    /**
     * 新增资源，并对应修改产品
     * @param resource
     */
    void insertResourceBusiness(Resource resource);
    /**
     * 修改资源，并对应修改产品
     * @param resource
     */
    void updateResourceBusiness(Resource resource);
}
