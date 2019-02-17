package com.jcnc.services.user.service;

import com.jcnc.services.user.model.generated.User;

/**
 * 用户服务
 * @author shihao.li
 * @date 2019-2-16
 */
public interface UserService {
    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    User queryUserByName(String userName);
}
