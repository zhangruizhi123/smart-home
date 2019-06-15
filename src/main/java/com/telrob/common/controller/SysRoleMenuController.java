package com.telrob.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.telrob.common.bean.ResponseResult;
import com.telrob.common.entity.SysRoleMenu;
import com.telrob.common.entity.SysRoleMenuExample;
import com.telrob.common.service.BaseService;
import com.telrob.common.service.SysRoleMenuService;

@Controller
@RequestMapping("/sysRoleMenu")
public class SysRoleMenuController extends BaseController<SysRoleMenu, SysRoleMenuExample, Integer> {

	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	@Override
	public BaseService<SysRoleMenu, SysRoleMenuExample, Integer> getBaseService() {
		return sysRoleMenuService;
	}
	
	
	@RequestMapping("findByMenuId")
	@ResponseBody
	public ResponseResult findByMenuId(Integer menuId) {
		ResponseResult result=new ResponseResult();
		try {
			result=sysRoleMenuService.findByMenuId(menuId);
		}catch(Exception e) {
			result.setCode(101);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("updateRoleMenus")
	@ResponseBody
	public ResponseResult updateRoleMenus(Integer menuId,@RequestParam(value="roles[]",required=false)Integer[] roleIds,@RequestParam(value="uroles[]",required=false)Integer[] uroles) {
		ResponseResult result=new ResponseResult();
		try {
			result=sysRoleMenuService.updateRoleMenus(menuId,roleIds,uroles);
		}catch(Exception e) {
			result.setCode(101);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	

}
