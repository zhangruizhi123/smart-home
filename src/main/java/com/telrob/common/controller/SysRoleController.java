package com.telrob.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telrob.common.entity.SysRole;
import com.telrob.common.entity.SysRoleExample;
import com.telrob.common.service.BaseService;
import com.telrob.common.service.SysRoleService;

@Controller
@RequestMapping("/sysRole")
public class SysRoleController extends BaseController<SysRole, SysRoleExample, Integer> {

	@Autowired
	private SysRoleService sysRoleService;
	
	
	@Override
	public BaseService<SysRole, SysRoleExample, Integer> getBaseService() {
		return sysRoleService;
	}

}
