package com.jcnc.controller;

import com.google.gson.Gson;
import com.jcnc.common.util.EnumJsonConverter;
import com.jcnc.common.vo.JCResponse;
import com.jcnc.common.vo.RetCode;
import com.jcnc.services.resource.enums.AvailStatusEnum;
import com.jcnc.services.resource.model.generated.Resource;
import com.jcnc.services.resource.service.ResourceService;
import com.jcnc.services.resource.vo.ResourceVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 资源控制类
 *
 * @author shihao.li
 * @date 2019-2-16
 */
@Controller
@RequestMapping("resource")
public class ResourceController {

    private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private ResourceService resourceService;

    private Gson gson = new Gson();

    /**
     * 跳转到资源页面
     * @return
     */
    @RequestMapping("/toResource")
    public ModelAndView toResource() {
        ModelAndView mav = new ModelAndView("system/resource");
        List<ResourceVo> voList = resourceService.queryPackageAllResources();
        mav.addObject("availStatusEnum", EnumJsonConverter.buildEnumJson(AvailStatusEnum.class));
        mav.addObject("nodes", gson.toJson(voList));
        return mav;
    }

    /**
     * 跳转到修改资源页面
     * @param resource
     * @return
     */
    @RequestMapping("/toUpdateResource")
    public ModelAndView toUpdateResource(Resource resource) {
        ModelAndView mav = new ModelAndView("system/updateResource");
        //根据资源id,获取对应的资源
        List<Resource> resourceList = resourceService.queryResourceByExample(resource);

        Long parentId = resourceList.get(0).getParentId();
        Resource parentResouce = new Resource();
        parentResouce.setResourceId(parentId);
        List<Resource> parentList = resourceService.queryResourceByExample(parentResouce);

        mav.addObject("resource", resourceList.get(0));
        if (parentList != null && parentList.size() == 1) {
            mav.addObject("parentResouce", parentList.get(0));
        } else {
            mav.addObject("parentResouce", resourceList.get(0));
        }
        return mav;
    }

    /**
     * 根据资源id,获取对应的资源
     *
     * @param resource
     * @return
     */
    @RequestMapping("/getResourceById")
    @ResponseBody
    public Object getResourceById(Resource resource) {
        logger.info("【资源管理】根据资源id获取资源_开始,入参:" + gson.toJson(resource));
        JCResponse res;
        try {
            if (resource.getResourceId() == null) {
                return new JCResponse(RetCode.INVALID_ARGS);
            }
            //根据资源id,获取对应的资源
            List<Resource> resourceList = resourceService.queryResourceByExample(resource);
            res = new JCResponse(RetCode.SUCCESS);
            res.setData(resourceList.get(0));
        } catch (Exception e) {
            logger.error("【资源管理】根据资源id获取资源_异常,异常原因:", e);
            res = new JCResponse(RetCode.FAILURE);
        }
        logger.info("【资源管理】根据资源id获取资源_结束");
        return res;
    }

    /**
     * 根据资源id,修改对应的资源
     */
    @RequestMapping("/updateResource")
    @ResponseBody
    public Object updateResource(Resource resource) {
        logger.info("【资源管理】修改资源_开始,入参:" + gson.toJson(resource));
        JCResponse res;
        try {
            if (StringUtils.isEmpty(resource.getResourceName()) || resource.getResourceType() == null) {
                return new JCResponse(RetCode.INVALID_ARGS);
            }
//            int result = resourceService.updateResourceById(resource);
//            logger.info("【资源管理】修改资源,修改条数:" + result);
            res = new JCResponse(RetCode.SUCCESS);
        } catch (Exception e) {
            logger.error("【资源管理】修改资源_异常,异常原因:", e);
            res = new JCResponse(RetCode.FAILURE);
        }
        logger.info("【资源管理】修改资源_结束");
        return res;
    }
}
