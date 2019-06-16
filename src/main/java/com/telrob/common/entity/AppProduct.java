package com.telrob.common.entity;

import java.util.Date;

public class AppProduct {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_product.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_product.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_product.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_product.project_id
     *
     * @mbggenerated
     */
    private Integer projectId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_product.product_key
     *
     * @mbggenerated
     */
    private String productKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_product.attribute
     *
     * @mbggenerated
     */
    private String attribute;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_product.type
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_product.state
     *
     * @mbggenerated
     */
    private Integer state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_product.c_time
     *
     * @mbggenerated
     */
    private Date cTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_product.id
     *
     * @return the value of app_product.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_product.id
     *
     * @param id the value for app_product.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_product.name
     *
     * @return the value of app_product.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_product.name
     *
     * @param name the value for app_product.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_product.user_id
     *
     * @return the value of app_product.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_product.user_id
     *
     * @param userId the value for app_product.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_product.project_id
     *
     * @return the value of app_product.project_id
     *
     * @mbggenerated
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_product.project_id
     *
     * @param projectId the value for app_product.project_id
     *
     * @mbggenerated
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_product.product_key
     *
     * @return the value of app_product.product_key
     *
     * @mbggenerated
     */
    public String getProductKey() {
        return productKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_product.product_key
     *
     * @param productKey the value for app_product.product_key
     *
     * @mbggenerated
     */
    public void setProductKey(String productKey) {
        this.productKey = productKey == null ? null : productKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_product.attribute
     *
     * @return the value of app_product.attribute
     *
     * @mbggenerated
     */
    public String getAttribute() {
        return attribute;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_product.attribute
     *
     * @param attribute the value for app_product.attribute
     *
     * @mbggenerated
     */
    public void setAttribute(String attribute) {
        this.attribute = attribute == null ? null : attribute.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_product.type
     *
     * @return the value of app_product.type
     *
     * @mbggenerated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_product.type
     *
     * @param type the value for app_product.type
     *
     * @mbggenerated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_product.state
     *
     * @return the value of app_product.state
     *
     * @mbggenerated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_product.state
     *
     * @param state the value for app_product.state
     *
     * @mbggenerated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_product.c_time
     *
     * @return the value of app_product.c_time
     *
     * @mbggenerated
     */
    public Date getcTime() {
        return cTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_product.c_time
     *
     * @param cTime the value for app_product.c_time
     *
     * @mbggenerated
     */
    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}