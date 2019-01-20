package com.jcnc.services.visitor.service.impl;

import com.jcnc.common.service.BaseService;
import com.jcnc.services.visitor.dao.customized.VisitorMessageDao;
import com.jcnc.services.visitor.model.customized.VisitorMessageModel;
import com.jcnc.services.visitor.service.VisitorMessageService;
import org.springframework.stereotype.Service;

/**
 * 访客留言服务
 * @author shihao.li
 * @date 2019-1-9
 */
@Service
public class VisitorMessageServiceImpl extends BaseService implements VisitorMessageService {

    private VisitorMessageDao getVisitorMessageDao(){
        return sqlSession.getMapper(VisitorMessageDao.class);
    }

    @Override
    public int saveVisitorMessage(VisitorMessageModel param) {
        return getVisitorMessageDao().saveVisitorMessage(param);
    }
}
