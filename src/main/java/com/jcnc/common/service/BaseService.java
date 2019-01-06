package com.jcnc.common.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 所有Service的基类，用来注入sqlSession
 * @author shihao.li
 * @date 2019-1-3
 */
public abstract class BaseService {

    /**
     * sqlSession
     */
    @Autowired
    @Qualifier("sessionTemplate")
    protected SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

}
