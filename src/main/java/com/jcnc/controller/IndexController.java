package com.jcnc.controller;

import com.jcnc.common.vo.JCResponse;
import com.jcnc.common.vo.RetCode;
import com.jcnc.services.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录控制类
 * @author shihao.li
 * @date 2019-2-16
 */
@Controller
@RequestMapping("index")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private ResourceController resourceController;

    /**
     * 跳转到登录页
     * @return
     */
    @RequestMapping("/toLogin")
    public ModelAndView toLogin() {
        ModelAndView mav = new ModelAndView("system/login");
        return mav;
    }

    /**
     * 登录操作
     * @param request
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, String userName, String password) {
        logger.info("【登录】进入登录方法");
        ModelAndView mav = new ModelAndView("system/login");
        JCResponse res;
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            res = new JCResponse(RetCode.FAILURE);
            res.setData("请输入用户名、密码");
            request.setAttribute("result", res);
            return mav;
        }
        String encryptPassword = userService.userLogin(userName, password);
        if (StringUtils.isBlank(encryptPassword)) {
            res = new JCResponse(RetCode.FAILURE);
            res.setData("用户名/密码输入错误, 请重新输入");
            request.setAttribute("result", res);
            return mav;
        }
        logger.info("【登录】登录成功");
        return resourceController.toResource(userName, password);
    }
}
