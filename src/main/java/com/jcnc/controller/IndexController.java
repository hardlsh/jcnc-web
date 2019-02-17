package com.jcnc.controller;

import com.jcnc.common.vo.JCResponse;
import com.jcnc.common.vo.RetCode;
import com.jcnc.services.user.model.generated.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
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
    private UserController userController;

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
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        DefaultWebSessionManager shiroSessionManager = new DefaultWebSessionManager();
        long sessionStartTime = subject.getSession().getStartTimestamp().getTime();
        long lengthenTimeOut = subject.getSession().getTimeout();
        // 提前1秒去判断,防止if没进,等执行下面的时候它却失效了      user为null,是第一次进login方法,还没有登陆
        if (((System.currentTimeMillis() - sessionStartTime) >= lengthenTimeOut - 1000) ||
                user == null) {
            // 移除线程里面的subject
            ThreadContext.remove(ThreadContext.SUBJECT_KEY);
            // 移除失效的session
            shiroSessionManager.getSessionDAO().delete(subject.getSession());
        }

        logger.info("【登录】进入登录方法");
        if (user != null && StringUtils.isNotBlank(user.getUserName())) {
            return userController.toUser();
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
}
