package com.telrob.common.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.telrob.common.bean.ResponseResult;
import com.telrob.common.consts.Constant;
import com.telrob.common.entity.AppProject;
import com.telrob.common.entity.AppProjectExample;
import com.telrob.common.entity.SysUser;
import com.telrob.common.service.AppProjectService;
import com.telrob.common.service.BaseService;
import com.telrob.common.utils.StringUtils;

import sun.swing.StringUIClientPropertyKey;

@Controller
@RequestMapping("/appProject")
public class AppProjectController extends BaseController<AppProject, AppProjectExample, Integer> {

	@Autowired
	private AppProjectService appProjectService;
	
	@Override
	public BaseService<AppProject, AppProjectExample, Integer> getBaseService() {
		return appProjectService;
	}
	
	@RequestMapping("/insertSeletive")
	@ResponseBody
	public ResponseResult insertSeletive(@RequestBody AppProject item,HttpServletRequest request) {
		SysUser user=(SysUser)request.getSession().getAttribute(Constant.USER_LOGINED);
		Integer id=user.getId();
		item.setUserId(id);
		item.setModifyTime(new Date());
		item.setcTime(new Date());
		item.setProjectKey(StringUtils.getUUID());
		return super.insertSeletive(item,request);
	}
}
