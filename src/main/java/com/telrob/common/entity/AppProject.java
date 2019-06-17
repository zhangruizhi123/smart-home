package com.telrob.common.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AppProject {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_project.id
	 * @mbg.generated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_project.project_name
	 * @mbg.generated
	 */
	private String projectName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_project.project_key
	 * @mbg.generated
	 */
	private String projectKey;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_project.user_id
	 * @mbg.generated
	 */
	private Integer userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_project.c_time
	 * @mbg.generated
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date cTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_project.modify_time
	 * @mbg.generated
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date modifyTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_project.remarks
	 * @mbg.generated
	 */
	private String remarks;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_project.id
	 * @return  the value of app_project.id
	 * @mbg.generated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_project.id
	 * @param id  the value for app_project.id
	 * @mbg.generated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_project.project_name
	 * @return  the value of app_project.project_name
	 * @mbg.generated
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_project.project_name
	 * @param projectName  the value for app_project.project_name
	 * @mbg.generated
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName == null ? null : projectName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_project.project_key
	 * @return  the value of app_project.project_key
	 * @mbg.generated
	 */
	public String getProjectKey() {
		return projectKey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_project.project_key
	 * @param projectKey  the value for app_project.project_key
	 * @mbg.generated
	 */
	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey == null ? null : projectKey.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_project.user_id
	 * @return  the value of app_project.user_id
	 * @mbg.generated
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_project.user_id
	 * @param userId  the value for app_project.user_id
	 * @mbg.generated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_project.c_time
	 * @return  the value of app_project.c_time
	 * @mbg.generated
	 */
	public Date getcTime() {
		return cTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_project.c_time
	 * @param cTime  the value for app_project.c_time
	 * @mbg.generated
	 */
	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_project.modify_time
	 * @return  the value of app_project.modify_time
	 * @mbg.generated
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_project.modify_time
	 * @param modifyTime  the value for app_project.modify_time
	 * @mbg.generated
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_project.remarks
	 * @return  the value of app_project.remarks
	 * @mbg.generated
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_project.remarks
	 * @param remarks  the value for app_project.remarks
	 * @mbg.generated
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}
}