package com.jcnc.controller;

import com.jcnc.common.constant.Constants;
import com.jcnc.services.resource.model.customized.ResourceModel;
import com.jcnc.services.resource.service.ResourceService;
import com.jcnc.services.resource.vo.ResourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 主控制器类
 * @author shihao.li
 * @date 2018-11-06
 */
@Controller
@RequestMapping("main")
public class MainController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 跳转到网站首页
     * @return
     */
    @RequestMapping("/toMain")
    public ModelAndView toMain(){
        ModelAndView mav = new ModelAndView("main");
        List<ResourceVo> resourceVoList = resourceService.queryPackageMenuUserResources(new ResourceModel());
        mav.addObject("menus", resourceVoList);
        mav.addObject("mainMenu", Constants.MAIN_MENU_INDEX);
        return mav;
    }

    /**
     * 跳转到公司简介页面
     * @return
     */
    @RequestMapping("/toAbout")
    public ModelAndView toAbout(){
        ModelAndView mav = new ModelAndView("mainmenu/about");
        mav.addObject("mainMenu", Constants.MAIN_MENU_ABOUT);
        return mav;
    }

    /**
     * 跳转到产品中心页面
     * @return
     */
    @RequestMapping("/toProductCenter")
    public ModelAndView toProductCenter(){
        ModelAndView mav = new ModelAndView("productCenter");
        return mav;
    }

    /**
     * 跳转到应用实例页面
     * @return
     */
    @RequestMapping("/toExamples")
    public ModelAndView toExamples(){
        ModelAndView mav = new ModelAndView("examples");
        return mav;
    }

    /**
     * 跳转到设备能力页面
     * @return
     */
    @RequestMapping("/toEquipment")
    public ModelAndView toEquipment(){
        ModelAndView mav = new ModelAndView("equipment");
        return mav;
    }

    /**
     * 跳转到资质荣誉页面
     * @return
     */
    @RequestMapping("/toAptitudeHonor")
    public ModelAndView toAptitudeHonor(){
        ModelAndView mav = new ModelAndView("aptitudeHonor");
        return mav;
    }

    /**
     * 跳转到联系我们页面
     * @return
     */
    @RequestMapping("/toContact")
    public ModelAndView toContact(){
        ModelAndView mav = new ModelAndView("mainmenu/contact");
        mav.addObject("mainMenu", Constants.MAIN_MENU_CONTACT);
        return mav;
    }

    @RequestMapping("/toTest")
    public ModelAndView toTest(){
        ModelAndView mav = new ModelAndView("test");
        return mav;
    }
}
