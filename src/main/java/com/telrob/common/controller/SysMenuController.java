package com.telrob.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.telrob.common.bean.ResponseResult;
import com.telrob.common.consts.Constant;
import com.telrob.common.entity.SysMenu;
import com.telrob.common.entity.SysMenuExample;
import com.telrob.common.entity.SysUser;
import com.telrob.common.service.BaseService;
import com.telrob.common.service.SysMenuService;

@Controller
@RequestMapping({"sysMenu"})
public class SysMenuController extends BaseController<SysMenu, SysMenuExample, Integer>{
	@Autowired
  	private SysMenuService sysMenuService;
  
  	@Override
	public BaseService<SysMenu, SysMenuExample, Integer> getBaseService() {
		return sysMenuService;
	}
  
  @RequestMapping({"list"})
  @ResponseBody
  public ResponseResult listMenu(Integer id,HttpServletRequest request)
  {
	  HttpSession session=request.getSession();
	  SysUser user =(SysUser)session.getAttribute(Constant.USER_LOGINED);
	  Integer roleId=user.getRoleId();
    ResponseResult result = new ResponseResult();
    try
    {
      result = this.sysMenuService.listMenu(id,roleId);
    }
    catch (Exception e)
    {
      result.setCode(101);
      result.setMessage(e.getMessage());
    }
    return result;
  }

	
}
