package com.jcnc.services.resource.service.impl;
import java.util.Date;

import com.jcnc.common.constant.Constants;
import com.jcnc.common.enums.AvailStatusEnum;
import com.jcnc.common.enums.ResourceLevelEnum;
import com.jcnc.common.enums.ResourceTypeEnum;
import com.jcnc.common.service.BaseService;
import com.jcnc.services.product.model.generated.Product;
import com.jcnc.services.product.service.ProductService;
import com.jcnc.services.resource.dao.customized.ResourceDao;
import com.jcnc.services.resource.model.customized.ResourceModel;
import com.jcnc.services.resource.model.generated.Resource;
import com.jcnc.services.resource.model.generated.ResourceExample;
import com.jcnc.services.resource.service.ResourceService;
import com.jcnc.services.resource.vo.ResourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private ProductService productService;

    @Override
    public Resource getResourceById(Long resourceId) {
        return getResourceDao().getResourceById(resourceId);
    }

    @Override
    public Resource getResourceByName(String resourceName){
        return getResourceDao().getResourceByName(resourceName);
    }

    @Override
    public List<ResourceVo> queryPackageResources(ResourceModel model) {
        List<ResourceVo> voList = new ArrayList<>();
        model.setResourceType(ResourceTypeEnum.MENU.getKey());
        List<ResourceModel> resourceList = getResourceDao().queryUserResources(model);
        // 先放入一级菜单
        for (ResourceModel menu : resourceList) {
            if (menu.getLevel() == ResourceLevelEnum.FIRST_MENU.getKey()) {
                ResourceVo firstvo = new ResourceVo();
                firstvo.setMenu(menu);
                firstvo.setChilds(new ArrayList<ResourceModel>());
                voList.add(firstvo);
            }
        }
        // 放入二级菜单
        for (ResourceModel menu : resourceList) {
            if (menu.getLevel() == ResourceLevelEnum.SECOND_MENU.getKey()) {
                for (ResourceVo firstvo : voList) {
                    if (firstvo.getMenu().getResourceId().equals(menu.getParentId())) {
                        firstvo.getChilds().add(menu);
                        break;
                    }
                }
            }
        }
        return voList;
    }

    @Override
    public List<ResourceVo> queryPackageAllResources() {
        // 查询所有资源
        List<Resource> allList = getResourceDao().selectByExample(new ResourceExample());
        // 按可用状态进行选中
        List<ResourceVo> resouceLit = getPackageResources(allList, allList, AvailStatusEnum.AVAILABLE.getKey());
        List<ResourceVo> rootResourceVo = getRootResourceVo();
        if (rootResourceVo != null) {
            rootResourceVo.get(0).setChildren(resouceLit);
            return rootResourceVo;
        } else {
            return resouceLit;
        }
    }
    private List<ResourceVo> getRootResourceVo(){
        Resource resource = new Resource();
        resource.setLevel(ResourceLevelEnum.ROOT_MENU.getKey());
        ResourceExample example = convertResourceToExample(resource);
        List<Resource> allList = getResourceDao().selectByExample(example);
        if (allList != null && allList.size() == 1) {
            List<ResourceVo> voList = new ArrayList<>();
            ResourceVo vo = new ResourceVo();
            vo.setId(allList.get(0).getResourceId());
            vo.setText(allList.get(0).getResourceName());
            vo.setSelected(true);
            voList.add(vo);
            return voList;
        } else {
            return null;
        }
    }

    /**
     * 组装资源,并进行相应选中
     * @param: allList 全部资源; selectedList 需要选中的资源
     * @param: status 可用状态的资源
     */
    private List<ResourceVo> getPackageResources(List<Resource> allList, List selectedList, Integer status) {
        //一级菜单
        List<ResourceVo> voList = new ArrayList<>();
        // 选中可用的资源
        Map<Long, Resource> selectedMap = new HashMap<>();
        if (selectedList != null && selectedList.size() > 0) {
            for (int i=0; i<selectedList.size(); i++) {
                Resource res = (Resource) (selectedList.get(i));
                if (status == null) {
                    selectedMap.put(res.getResourceId(), res);
                }else if (status != null && res.getStatus().equals(status)) {
                    selectedMap.put(res.getResourceId(), res);
                }
            }
        }
        // 放入一级菜单
        for (Resource res : allList) {
            if (res.getLevel() == 1) {
                ResourceVo vo = new ResourceVo();
                vo.setId(res.getResourceId());
                vo.setText(res.getResourceName());
                vo.setChildren(new ArrayList<ResourceVo>());
                if (selectedMap.containsKey(res.getResourceId())) {
                    vo.setSelected(true);
                }else {
                    vo.setSelected(false);
                }
                voList.add(vo);
            }
        }
        //放入二级菜单
        for (Resource res : allList) {
            if (res.getLevel() == 2) {
                for (ResourceVo resVo : voList) {
                    if (resVo.getId().equals(res.getParentId())) {
                        ResourceVo vo = new ResourceVo();
                        vo.setId(res.getResourceId());
                        vo.setText(res.getResourceName());
                        vo.setChildren(new ArrayList<ResourceVo>());
                        if (selectedMap.containsKey(res.getResourceId())) {
                            vo.setSelected(true);
                        }else {
                            vo.setSelected(false);
                        }
                        resVo.getChildren().add(vo);
                        break;
                    }
                }
            }
        }
        return voList;
    }

    @Override
    public List<Resource> queryResourceByExample(Resource resource) {
        ResourceExample example = convertResourceToExample(resource);
        return getResourceDao().selectByExample(example);
    }

    /**
     * 转换参数    resource-->example
     */
    private ResourceExample convertResourceToExample(Resource resource){
        ResourceExample example = new ResourceExample();
        ResourceExample.Criteria criteria = example.createCriteria();
        if (resource.getStatus() != null) {
            criteria.andStatusEqualTo(resource.getStatus());
        }
        if (resource.getResourceType() != null) {
            criteria.andResourceTypeEqualTo(resource.getResourceType());
        }
        if (resource.getResourceId() != null) {
            criteria.andResourceIdEqualTo(resource.getResourceId());
        }
        if (resource.getLevel() != null) {
            criteria.andLevelEqualTo(resource.getLevel());
        }
        return example;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertResourceBusiness(Resource resource){
        String resourcePath = "";
        if (resource.getLevel().equals(ResourceLevelEnum.SECOND_MENU.getKey())) {
            resourcePath = Constants.BASE_PRODUCT_PATH + resource.getProductId();
        }
        resource.setResourcePath(resourcePath);
        getResourceDao().insertResourceReturnId(resource);

        if (resource.getLevel().equals(ResourceLevelEnum.FIRST_MENU.getKey())) {
            Resource showResource = new Resource();
            showResource.setResourceName(resource.getResourceName() + "展示");
            showResource.setResourceType(ResourceTypeEnum.MENU.getKey());
            showResource.setParentId(resource.getResourceId());
            showResource.setParentName(resource.getResourceName());
            showResource.setResourcePath(Constants.PRODUCT_SHOW_PATH + resource.getResourceId());
            showResource.setLevel(ResourceLevelEnum.SECOND_MENU.getKey());
            showResource.setSequence(0);
            getResourceDao().insertResourceReturnId(showResource);
        } else if (resource.getLevel().equals(ResourceLevelEnum.SECOND_MENU.getKey())) {
            Product product = new Product();
            product.setProductId(resource.getProductId());
            product.setProductType(resource.getParentId());
            productService.updateProductById(product);
        }
    }
}
