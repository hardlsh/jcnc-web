package com.jcnc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 产品控制器类
 * @author shihao.li
 * @date 2019-1-6
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @RequestMapping("/toMainProduct")
    public ModelAndView toMainProduct() {
        ModelAndView mav = new ModelAndView("product/main/mainproducts");
        return mav;
    }

    @RequestMapping("/toBaseMainProduct")
    public ModelAndView toBaseMainProduct() {
        ModelAndView mav = new ModelAndView("product/main/basemainproduct");
        return mav;
    }
}
