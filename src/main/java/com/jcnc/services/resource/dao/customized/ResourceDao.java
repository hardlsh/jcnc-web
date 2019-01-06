package com.jcnc.services.resource.dao.customized;

import com.jcnc.services.resource.dao.generated.ResourceMapper;
import com.jcnc.services.resource.model.customized.ResourceModel;

import java.util.List;

/**
 * 系统资源 Dao类
 * @author shihao.li
 * @date 2019-1-3
 */
public interface ResourceDao extends ResourceMapper{
    /**
     * 根据参数,获取用户资源
     * @param model
     * @return
     */
    List<ResourceModel> queryUserResources(ResourceModel model);
}
