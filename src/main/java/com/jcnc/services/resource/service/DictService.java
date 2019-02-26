package com.jcnc.services.resource.service;

import com.jcnc.services.resource.model.generated.DictItem;

import java.util.List;

/**
 * 字典服务
 * @author shihao.li
 * @date 2019-2-26
 */
public interface DictService {
    /**
     * 查询字典项值
     * @param dictItem
     * @return
     */
    List<DictItem> queryDictItemList(DictItem dictItem);
}
