package com.telrob.common.controller;

import com.telrob.common.bean.ResponseResult;
import com.telrob.common.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"sysMenu"})
public class SysMenuController{
  @Autowired
  private SysMenuService sysMenuService;
  
  @RequestMapping({"list"})
  @ResponseBody
  public ResponseResult listMenu(Integer id)
  {
    ResponseResult result = new ResponseResult();
    try
    {
      result = this.sysMenuService.listMenu(id);
    }
    catch (Exception e)
    {
      result.setCode(101);
      result.setMessage(e.getMessage());
    }
    return result;
  }
}
