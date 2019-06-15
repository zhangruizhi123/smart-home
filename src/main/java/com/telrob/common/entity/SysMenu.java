package com.telrob.common.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsExclude;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.telrob.common.utils.annotation.Ignore;

public class SysMenu {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_menu.id
	 * @mbg.generated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_menu.name
	 * @mbg.generated
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_menu.url
	 * @mbg.generated
	 */
	private String url;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_menu.number
	 * @mbg.generated
	 */
	private Integer number;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_menu.pid
	 * @mbg.generated
	 */
	private Integer pid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_menu.icon
	 * @mbg.generated
	 */
	private String icon;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_menu.c_time
	 * @mbg.generated
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_menu.c_user
	 * @mbg.generated
	 */
	private Integer cUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_menu.modify_time
	 * @mbg.generated
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date modifyTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_menu.id
	 * @return  the value of sys_menu.id
	 * @mbg.generated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_menu.id
	 * @param id  the value for sys_menu.id
	 * @mbg.generated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_menu.name
	 * @return  the value of sys_menu.name
	 * @mbg.generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_menu.name
	 * @param name  the value for sys_menu.name
	 * @mbg.generated
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_menu.url
	 * @return  the value of sys_menu.url
	 * @mbg.generated
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_menu.url
	 * @param url  the value for sys_menu.url
	 * @mbg.generated
	 */
	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_menu.number
	 * @return  the value of sys_menu.number
	 * @mbg.generated
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_menu.number
	 * @param number  the value for sys_menu.number
	 * @mbg.generated
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_menu.pid
	 * @return  the value of sys_menu.pid
	 * @mbg.generated
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_menu.pid
	 * @param pid  the value for sys_menu.pid
	 * @mbg.generated
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_menu.icon
	 * @return  the value of sys_menu.icon
	 * @mbg.generated
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_menu.icon
	 * @param icon  the value for sys_menu.icon
	 * @mbg.generated
	 */
	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_menu.c_time
	 * @return  the value of sys_menu.c_time
	 * @mbg.generated
	 */
	public Date getcTime() {
		return cTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_menu.c_time
	 * @param cTime  the value for sys_menu.c_time
	 * @mbg.generated
	 */
	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_menu.c_user
	 * @return  the value of sys_menu.c_user
	 * @mbg.generated
	 */
	public Integer getcUser() {
		return cUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_menu.c_user
	 * @param cUser  the value for sys_menu.c_user
	 * @mbg.generated
	 */
	public void setcUser(Integer cUser) {
		this.cUser = cUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_menu.modify_time
	 * @return  the value of sys_menu.modify_time
	 * @mbg.generated
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_menu.modify_time
	 * @param modifyTime  the value for sys_menu.modify_time
	 * @mbg.generated
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	@Ignore("")
	private List<SysMenu> subMenu = new ArrayList<SysMenu>();
	  
	  public List<SysMenu> getSubMenu()
	  {
	    return this.subMenu;
	  }
	  
	  public void addSubMenu(SysMenu menu)
	  {
	    this.subMenu.add(menu);
	  }
	  
	  public void setSubMenu(List<SysMenu> subMenu)
	  {
	    this.subMenu = subMenu;
	  }
}