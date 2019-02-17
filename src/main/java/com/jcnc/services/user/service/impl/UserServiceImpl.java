package com.jcnc.services.user.service.impl;

import com.jcnc.common.service.BaseService;
import com.jcnc.services.user.dao.customized.UserDao;
import com.jcnc.services.user.model.generated.User;
import com.jcnc.services.user.model.generated.UserExample;
import com.jcnc.services.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public User queryUserByName(String userName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> list = getUserDao().selectByExample(userExample);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
}
