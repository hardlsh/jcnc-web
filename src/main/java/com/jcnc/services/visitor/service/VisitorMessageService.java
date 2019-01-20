package com.jcnc.services.visitor.service;

import com.jcnc.services.visitor.model.customized.VisitorMessageModel;

/**
 * 访客留言服务
 * @author shihao.li
 * @date 2019-1-9
 */
public interface VisitorMessageService {
    /**
     * 保存访客留言信息
     * @param param
     */
    void saveVisitorMessage(VisitorMessageModel param);
}
