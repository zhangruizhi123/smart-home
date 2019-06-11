package com.telrob.common.mapper;

import com.telrob.common.entity.SysIcon;
import com.telrob.common.entity.SysIconExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysIconMapper extends BaseMapper<SysIcon, SysIconExample, Integer> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_icon
     *
     * @mbggenerated
     */
    long countByExample(SysIconExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_icon
     *
     * @mbggenerated
     */
    int deleteByExample(SysIconExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_icon
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_icon
     *
     * @mbggenerated
     */
    int insert(SysIcon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_icon
     *
     * @mbggenerated
     */
    int insertSelective(SysIcon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_icon
     *
     * @mbggenerated
     */
    List<SysIcon> selectByExample(SysIconExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_icon
     *
     * @mbggenerated
     */
    SysIcon selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_icon
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysIcon record, @Param("example") SysIconExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_icon
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysIcon record, @Param("example") SysIconExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_icon
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysIcon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_icon
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysIcon record);
}