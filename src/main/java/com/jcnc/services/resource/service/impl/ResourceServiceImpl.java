package com.jcnc.services.resource.service.impl;

import com.jcnc.common.service.BaseService;
import com.jcnc.services.resource.dao.customized.ResourceDao;
import com.jcnc.services.resource.model.customized.ResourceModel;
import com.jcnc.services.resource.service.ResourceService;
import com.jcnc.services.resource.vo.ResourceVo;
import com.jcnc.services.user.enums.ResourceLevelEnum;
import com.jcnc.services.user.enums.ResourceTypeEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统资源服务
 * @author shihao.li
 * @date 2019-1-3
 */
@Service
public class ResourceServiceImpl extends BaseService implements ResourceService{

    private ResourceDao getResourceDao(){
        return sqlSession.getMapper(ResourceDao.class);
    }

    @Override
    public List<ResourceVo> queryPackageMenuUserResources(ResourceModel model) {
        List<ResourceVo> voList = new ArrayList<>();
        model.setResourceType(ResourceTypeEnum.MENU.getKey());
        List<ResourceModel> resourceList = getResourceDao().queryUserResources(model);
        // 先放入一级菜单
        for (ResourceModel menu : resourceList) {
            if (menu.getLevel() == ResourceLevelEnum.FIRST_MENU.getKey()) {
                ResourceVo firstvo = new ResourceVo();
                firstvo.setMenu(menu);
                firstvo.setChildren(new ArrayList<ResourceModel>());
                voList.add(firstvo);
            }
        }
        // 放入二级菜单
        for (ResourceModel menu : resourceList) {
            if (menu.getLevel() == ResourceLevelEnum.SECOND_MENU.getKey()) {
                for (ResourceVo firstvo : voList) {
                    if (firstvo.getMenu().getResourceId().equals(menu.getParentId())) {
                        firstvo.getChildren().add(menu);
                        break;
                    }
                }
            }
        }
        return voList;
    }
}
