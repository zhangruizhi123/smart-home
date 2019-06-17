package com.telrob.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.telrob.common.entity.AppProduct;
import com.telrob.common.entity.AppProductExample;

public interface AppProductMapper extends BaseMapper<AppProduct, AppProductExample, Integer> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_product
     *
     * @mbggenerated
     */
    long countByExample(AppProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_product
     *
     * @mbggenerated
     */
    int deleteByExample(AppProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_product
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_product
     *
     * @mbggenerated
     */
    int insert(AppProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_product
     *
     * @mbggenerated
     */
    int insertSelective(AppProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_product
     *
     * @mbggenerated
     */
    List<AppProduct> selectByExample(AppProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_product
     *
     * @mbggenerated
     */
    AppProduct selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_product
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AppProduct record, @Param("example") AppProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_product
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AppProduct record, @Param("example") AppProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_product
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AppProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_product
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AppProduct record);
}