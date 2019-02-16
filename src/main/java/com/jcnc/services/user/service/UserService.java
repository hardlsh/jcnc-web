package com.jcnc.services.user.service;

/**
 * 用户服务
 * @author shihao.li
 * @date 2019-2-16
 */
public interface UserService {
    /**
     * 校验用户登录,并返回加密密码
     * @param userName
     * @param password
     * @return
     */
    String userLogin(String userName, String password);
}
