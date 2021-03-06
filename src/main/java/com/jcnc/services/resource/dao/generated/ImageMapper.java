package com.jcnc.services.resource.dao.generated;

import com.jcnc.services.resource.model.generated.Image;
import com.jcnc.services.resource.model.generated.ImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_image
     *
     * @mbggenerated Sat Feb 23 02:31:58 CST 2019
     */
    int countByExample(ImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_image
     *
     * @mbggenerated Sat Feb 23 02:31:58 CST 2019
     */
    int deleteByExample(ImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_image
     *
     * @mbggenerated Sat Feb 23 02:31:58 CST 2019
     */
    int deleteByPrimaryKey(Long imageId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_image
     *
     * @mbggenerated Sat Feb 23 02:31:58 CST 2019
     */
    int insert(Image record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_image
     *
     * @mbggenerated Sat Feb 23 02:31:58 CST 2019
     */
    int insertSelective(Image record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_image
     *
     * @mbggenerated Sat Feb 23 02:31:58 CST 2019
     */
    List<Image> selectByExample(ImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_image
     *
     * @mbggenerated Sat Feb 23 02:31:58 CST 2019
     */
    Image selectByPrimaryKey(Long imageId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_image
     *
     * @mbggenerated Sat Feb 23 02:31:58 CST 2019
     */
    int updateByExampleSelective(@Param("record") Image record, @Param("example") ImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_image
     *
     * @mbggenerated Sat Feb 23 02:31:58 CST 2019
     */
    int updateByExample(@Param("record") Image record, @Param("example") ImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_image
     *
     * @mbggenerated Sat Feb 23 02:31:58 CST 2019
     */
    int updateByPrimaryKeySelective(Image record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_sys_image
     *
     * @mbggenerated Sat Feb 23 02:31:58 CST 2019
     */
    int updateByPrimaryKey(Image record);
}