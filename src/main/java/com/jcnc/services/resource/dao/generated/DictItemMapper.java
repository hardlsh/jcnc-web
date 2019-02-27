package com.jcnc.services.resource.dao.generated;

import com.jcnc.services.resource.model.generated.DictItem;
import com.jcnc.services.resource.model.generated.DictItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_dict_item
     *
     * @mbggenerated Tue Feb 26 12:06:41 CST 2019
     */
    int countByExample(DictItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_dict_item
     *
     * @mbggenerated Tue Feb 26 12:06:41 CST 2019
     */
    int deleteByExample(DictItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_dict_item
     *
     * @mbggenerated Tue Feb 26 12:06:41 CST 2019
     */
    int deleteByPrimaryKey(Long itemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_dict_item
     *
     * @mbggenerated Tue Feb 26 12:06:41 CST 2019
     */
    int insert(DictItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_dict_item
     *
     * @mbggenerated Tue Feb 26 12:06:41 CST 2019
     */
    int insertSelective(DictItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_dict_item
     *
     * @mbggenerated Tue Feb 26 12:06:41 CST 2019
     */
    List<DictItem> selectByExample(DictItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_dict_item
     *
     * @mbggenerated Tue Feb 26 12:06:41 CST 2019
     */
    DictItem selectByPrimaryKey(Long itemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_dict_item
     *
     * @mbggenerated Tue Feb 26 12:06:41 CST 2019
     */
    int updateByExampleSelective(@Param("record") DictItem record, @Param("example") DictItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_dict_item
     *
     * @mbggenerated Tue Feb 26 12:06:41 CST 2019
     */
    int updateByExample(@Param("record") DictItem record, @Param("example") DictItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_dict_item
     *
     * @mbggenerated Tue Feb 26 12:06:41 CST 2019
     */
    int updateByPrimaryKeySelective(DictItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_dict_item
     *
     * @mbggenerated Tue Feb 26 12:06:41 CST 2019
     */
    int updateByPrimaryKey(DictItem record);
}