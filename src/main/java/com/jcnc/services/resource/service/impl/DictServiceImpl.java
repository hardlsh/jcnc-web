package com.jcnc.services.resource.service.impl;

import com.jcnc.common.service.BaseService;
import com.jcnc.services.resource.dao.generated.DictItemMapper;
import com.jcnc.services.resource.model.generated.DictItem;
import com.jcnc.services.resource.model.generated.DictItemExample;
import com.jcnc.services.resource.service.DictService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典服务
 * @author shihao.li
 * @date 2019-2-26
 */
@Service
public class DictServiceImpl extends BaseService implements DictService{

    @Override
    public List<DictItem> queryDictItemList(DictItem dictItem) {
        DictItemMapper dictItemMapper = sqlSession.getMapper(DictItemMapper.class);
        DictItemExample example = new DictItemExample();
        DictItemExample.Criteria criteria = example.createCriteria();
        criteria.andDictCodeEqualTo(dictItem.getDictCode());
        if(StringUtils.isNotBlank(dictItem.getItemCode())){
            criteria.andItemCodeEqualTo(dictItem.getItemCode());
        }
        example.setOrderByClause(" sequence asc ");
        return dictItemMapper.selectByExample(example);
    }
}
