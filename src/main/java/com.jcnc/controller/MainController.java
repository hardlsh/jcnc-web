package com.jcnc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 主控制器类
 * @author shihao.li
 * @date 2018-11-06
 */
@Controller
@RequestMapping("main")
public class MainController {

    /**
     * 跳转到网站首页
     * @return
     */
    @RequestMapping("/toTestIndex")
    public ModelAndView toTestIndex(){
        ModelAndView mav = new ModelAndView("new/testindex");
        return mav;
    }

    /**
     * 跳转到公司简介页面
     * @return
     */
    @RequestMapping("/toBrief")
    public ModelAndView toBrief(){
        ModelAndView mav = new ModelAndView("brief");
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
        ModelAndView mav = new ModelAndView("contact");
        return mav;
    }

}
