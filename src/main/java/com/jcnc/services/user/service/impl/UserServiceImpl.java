package com.jcnc.services.user.service.impl;

import com.jcnc.common.service.BaseService;
import com.jcnc.common.util.MD5Util;
import com.jcnc.services.user.dao.customized.UserDao;
import com.jcnc.services.user.model.customized.UserModel;
import com.jcnc.services.user.model.generated.User;
import com.jcnc.services.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户服务
 * @author shihao.li
 * @date 2019-2-16
 */
@Service
public class UserServiceImpl extends BaseService implements UserService{

    private UserDao getUserDao() {
        return sqlSession.getMapper(UserDao.class);
    }

    @Override
    public String userLogin(String userName, String password) {
        String encryptPassword = MD5Util.getEncryptData(password);
        User user = new User();
        user.setUserName(userName);
        user.setPassword(encryptPassword);
        UserModel userModel = getUserDao().userLogin(user);
        if (userModel != null) {
           return encryptPassword;
        }
        return null;
    }
}
