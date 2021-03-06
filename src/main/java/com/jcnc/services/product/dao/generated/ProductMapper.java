package com.jcnc.services.product.dao.generated;

import com.jcnc.services.product.model.generated.Product;
import com.jcnc.services.product.model.generated.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product
     *
     * @mbggenerated Wed Feb 27 21:08:51 CST 2019
     */
    int countByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product
     *
     * @mbggenerated Wed Feb 27 21:08:51 CST 2019
     */
    int deleteByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product
     *
     * @mbggenerated Wed Feb 27 21:08:51 CST 2019
     */
    int deleteByPrimaryKey(Long productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product
     *
     * @mbggenerated Wed Feb 27 21:08:51 CST 2019
     */
    int insert(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product
     *
     * @mbggenerated Wed Feb 27 21:08:51 CST 2019
     */
    int insertSelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product
     *
     * @mbggenerated Wed Feb 27 21:08:51 CST 2019
     */
    List<Product> selectByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product
     *
     * @mbggenerated Wed Feb 27 21:08:51 CST 2019
     */
    Product selectByPrimaryKey(Long productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product
     *
     * @mbggenerated Wed Feb 27 21:08:51 CST 2019
     */
    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product
     *
     * @mbggenerated Wed Feb 27 21:08:51 CST 2019
     */
    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product
     *
     * @mbggenerated Wed Feb 27 21:08:51 CST 2019
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product
     *
     * @mbggenerated Wed Feb 27 21:08:51 CST 2019
     */
    int updateByPrimaryKey(Product record);
}