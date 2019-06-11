package com.telrob.common.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.telrob.common.bean.ResponseResult;
import com.telrob.common.entity.SysUser;
import com.telrob.common.entity.SysUserExample;
import com.telrob.common.service.BaseService;
import com.telrob.common.service.SysUserService;
import com.telrob.common.utils.StringUtils;

@Controller
@RequestMapping("sysUser")
public class SysUserController extends BaseController<SysUser, SysUserExample, Integer>{
	@Autowired
	SysUserService SysUserService;
  
	public BaseService<SysUser, SysUserExample, Integer> getBaseService(){
		return this.SysUserService;
	}
	
	/**
	   * 插入
	   * @param item
	   * @return
	   */
	@RequestMapping("/insertSeletive")
	@ResponseBody
	@Override
	public ResponseResult insertSeletive(@RequestBody SysUser item) {
		// TODO Auto-generated method stub
		System.out.println(item.getPassword());
		item.setcTime(new Date());
		item.setModityTime(new Date());
		item.setPassword(StringUtils.MD5(item.getPassword()));
		return super.insertSeletive(item);
	}
}
