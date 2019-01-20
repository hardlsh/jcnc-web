package com.jcnc.services.visitor.dao.customized;

import com.jcnc.services.visitor.dao.generated.VisitorMessageMapper;
import com.jcnc.services.visitor.model.customized.VisitorMessageModel;

/**
 * 访客留言Dao
 * @author shihao.li
 * @date 2019-1-9
 */
public interface VisitorMessageDao extends VisitorMessageMapper{
    /**
     * 保存访客留言信息
     * @param param
     */
    int saveVisitorMessage(VisitorMessageModel param);
}
