package com.telrob.common.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AppDeviceRecode {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_device_recode.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_device_recode.mac
     *
     * @mbggenerated
     */
    private String mac;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_device_recode.attrib_name
     *
     * @mbggenerated
     */
    private String attribName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_device_recode.attrib_value
     *
     * @mbggenerated
     */
    private String attribValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_device_recode.type
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_device_recode.product_key
     *
     * @mbggenerated
     */
    private String productKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_device_recode.device_secret
     *
     * @mbggenerated
     */
    private String deviceSecret;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_device_recode.c_time
     *
     * @mbggenerated
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_device_recode.id
     *
     * @return the value of app_device_recode.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_device_recode.id
     *
     * @param id the value for app_device_recode.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_device_recode.mac
     *
     * @return the value of app_device_recode.mac
     *
     * @mbggenerated
     */
    public String getMac() {
        return mac;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_device_recode.mac
     *
     * @param mac the value for app_device_recode.mac
     *
     * @mbggenerated
     */
    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_device_recode.attrib_name
     *
     * @return the value of app_device_recode.attrib_name
     *
     * @mbggenerated
     */
    public String getAttribName() {
        return attribName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_device_recode.attrib_name
     *
     * @param attribName the value for app_device_recode.attrib_name
     *
     * @mbggenerated
     */
    public void setAttribName(String attribName) {
        this.attribName = attribName == null ? null : attribName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_device_recode.attrib_value
     *
     * @return the value of app_device_recode.attrib_value
     *
     * @mbggenerated
     */
    public String getAttribValue() {
        return attribValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_device_recode.attrib_value
     *
     * @param attribValue the value for app_device_recode.attrib_value
     *
     * @mbggenerated
     */
    public void setAttribValue(String attribValue) {
        this.attribValue = attribValue == null ? null : attribValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_device_recode.type
     *
     * @return the value of app_device_recode.type
     *
     * @mbggenerated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_device_recode.type
     *
     * @param type the value for app_device_recode.type
     *
     * @mbggenerated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_device_recode.product_key
     *
     * @return the value of app_device_recode.product_key
     *
     * @mbggenerated
     */
    public String getProductKey() {
        return productKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_device_recode.product_key
     *
     * @param productKey the value for app_device_recode.product_key
     *
     * @mbggenerated
     */
    public void setProductKey(String productKey) {
        this.productKey = productKey == null ? null : productKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_device_recode.device_secret
     *
     * @return the value of app_device_recode.device_secret
     *
     * @mbggenerated
     */
    public String getDeviceSecret() {
        return deviceSecret;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_device_recode.device_secret
     *
     * @param deviceSecret the value for app_device_recode.device_secret
     *
     * @mbggenerated
     */
    public void setDeviceSecret(String deviceSecret) {
        this.deviceSecret = deviceSecret == null ? null : deviceSecret.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_device_recode.c_time
     *
     * @return the value of app_device_recode.c_time
     *
     * @mbggenerated
     */
    public Date getcTime() {
        return cTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_device_recode.c_time
     *
     * @param cTime the value for app_device_recode.c_time
     *
     * @mbggenerated
     */
    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}