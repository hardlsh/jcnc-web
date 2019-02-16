package com.jcnc.controller;

import com.google.gson.Gson;
import com.jcnc.common.util.EnumJsonConverter;
import com.jcnc.services.resource.enums.AvailStatusEnum;
import com.jcnc.services.resource.service.ResourceService;
import com.jcnc.services.resource.vo.ResourceVo;
import com.jcnc.services.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 资源控制类
 * @author shihao.li
 * @date 2019-2-16
 */
@Controller
@RequestMapping("resource")
public class ResourceController {

    private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private ResourceService resourceService;

    private Gson gson = new Gson();

    @RequestMapping("/toResource")
    public ModelAndView toResource(String userName, String password){
        String encryptPassword = userService.userLogin(userName, password);
        if (StringUtils.isBlank(encryptPassword)) {
            logger.error("【！！！】请注意!非法链接!");
            return null;
        }
        ModelAndView mav = new ModelAndView("system/resource");
        List<ResourceVo> voList = resourceService.queryPackageAllResources();
        mav.addObject("availStatusEnum", EnumJsonConverter.buildEnumJson(AvailStatusEnum.class));
        mav.addObject("nodes", gson.toJson(voList));
        return mav;
    }
}
