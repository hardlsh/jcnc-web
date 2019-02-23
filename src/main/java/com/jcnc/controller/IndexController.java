package com.jcnc.controller;

import com.jcnc.common.vo.JCResponse;
import com.jcnc.common.vo.RetCode;
import com.jcnc.services.user.model.generated.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.RedirectView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录控制类
 * @author shihao.li
 * @date 2019-2-16
 */
@Controller
@RequestMapping("index")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

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
     * 跳转到用户管理页面
     * @return
     */
    @RequestMapping("/toUser")
    public ModelAndView toUser() {
        ModelAndView mav = new ModelAndView("system/user");
        // 从shiro的session中取activeUser
        Subject subject = SecurityUtils.getSubject();
        // 取身份信息(就是在自定义的realm中放入的Object类型的身份信息)
        User user = (User) subject.getPrincipal();
        if (user == null) {// session失效,跳转至登录页面
            return toLogin();
        }
        return mav;
    }

    /**
     * 登录操作
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        logger.info("【登录】进入登录方法");
        if (user != null && StringUtils.isNotBlank(user.getUserName())) {
            return toUser();
        }

        ModelAndView mav = new ModelAndView("system/login");
        JCResponse res;
        // 如果登录失败,从request中获取认证异常信息,shiroLoginFailure就是shiro异常类的全名
        String exceptionClassName = (String) request
                .getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        if (exceptionClassName != null) {
            logger.info("【登录】登录异常, exceptionClassName is {}", exceptionClassName);
            String error;
            if (UnknownAccountException.class.getName().equalsIgnoreCase(exceptionClassName)) {
                error = "用户名/密码错误, 请重新输入";
            } else if (IncorrectCredentialsException.class.getName().equalsIgnoreCase(exceptionClassName)) {
                error = "用户名/密码错误, 请重新输入";
            } else {
                error = "未知登录错误, 请联系管理员";
            }
            res = new JCResponse(RetCode.FAILURE);
            res.setData(error);
            logger.info("【登陆】用户登录失败, 失败原因: " + error);
            request.setAttribute("result", res);
        }
        return mav;
    }

    /**
     * 退出登录
     * @param request
     * @param response
     */
    @RequestMapping("/logout")
    public void logout(ServletRequest request, ServletResponse response) {
        logger.info("【登录】退出登录");
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            String redirectUrl = "/index.jsp";
            RedirectView view = new RedirectView(redirectUrl, true, true);
            view.renderMergedOutputModel(null, (HttpServletRequest) request, (HttpServletResponse) response);
        } catch (Exception e) {
            logger.error("【登录】退出登录错误,错误原因:", e);
        }
    }
}
