package com.telrob.common.mapper;

import com.telrob.common.entity.AppProject;
import com.telrob.common.entity.AppProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppProjectMapper extends BaseMapper<AppProject, AppProjectExample, Integer> {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_project
	 * @mbg.generated
	 */
	long countByExample(AppProjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_project
	 * @mbg.generated
	 */
	int deleteByExample(AppProjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_project
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_project
	 * @mbg.generated
	 */
	int insert(AppProject record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_project
	 * @mbg.generated
	 */
	int insertSelective(AppProject record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_project
	 * @mbg.generated
	 */
	List<AppProject> selectByExample(AppProjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_project
	 * @mbg.generated
	 */
	AppProject selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_project
	 * @mbg.generated
	 */
	int updateByExampleSelective(@Param("record") AppProject record, @Param("example") AppProjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_project
	 * @mbg.generated
	 */
	int updateByExample(@Param("record") AppProject record, @Param("example") AppProjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_project
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(AppProject record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_project
	 * @mbg.generated
	 */
	int updateByPrimaryKey(AppProject record);
}