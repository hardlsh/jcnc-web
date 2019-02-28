package com.jcnc.services.resource.dao.customized;

import com.jcnc.services.resource.dao.generated.ResourceMapper;
import com.jcnc.services.resource.model.customized.ResourceModel;
import com.jcnc.services.resource.model.generated.Resource;

import java.util.List;

/**
 * 系统资源 Dao类
 * @author shihao.li
 * @date 2019-1-3
 */
public interface ResourceDao extends ResourceMapper{
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
     * 根据参数,获取用户资源
     * @param model
     * @return
     */
    List<ResourceModel> queryUserResources(ResourceModel model);
    /**
     * 新增资源，并返回主键id
     * @param resource
     */
    void insertResourceReturnId(Resource resource);
}
