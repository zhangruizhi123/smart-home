package com.telrob.common.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telrob.common.bean.ResponseResult;
import com.telrob.common.entity.SysMenu;
import com.telrob.common.entity.SysMenuExample;
import com.telrob.common.entity.SysRoleMenu;
import com.telrob.common.entity.SysRoleMenuExample;
import com.telrob.common.mapper.BaseMapper;
import com.telrob.common.mapper.SysMenuMapper;
import com.telrob.common.mapper.SysRoleMenuMapper;

@Service
public class SysMenuService extends BaseService<SysMenu, SysMenuExample, Integer>
{
  @Autowired
  private SysMenuMapper sysMenuMapper;
  @Autowired
  private SysRoleMenuMapper sysRoleMenuMapper;
  
  @Override
  public BaseMapper<SysMenu, SysMenuExample, Integer> getMapper() {
  	return sysMenuMapper;
  }
  
  public ResponseResult listMenu(Integer id,Integer roleId)
  {
    ResponseResult result = new ResponseResult();
    result.setCode(0);
    if (id != null)
    {
      SysMenu menu = this.sysMenuMapper.selectByPrimaryKey(id);
      result.setData(menu);
    }
    else
    {
      List<SysMenu> resultMenu = new ArrayList<SysMenu>();
      SysMenuExample sysMenuExample=null;
      if(roleId!=null&&roleId>0) {
    	  SysRoleMenuExample sysRoleMenuExample=new SysRoleMenuExample();
    	  sysRoleMenuExample.createCriteria().andRoleIdEqualTo(roleId);
    	  List<SysRoleMenu> roleMenuList=sysRoleMenuMapper.selectByExample(sysRoleMenuExample);
    	  if(roleMenuList!=null&&roleMenuList.size()>0) {
    		  List<Integer>menuIdList=new ArrayList<Integer>();
    		  for(SysRoleMenu menu:roleMenuList) {
    			  menuIdList.add(menu.getMenuId());
    		  }
    		  sysMenuExample=new SysMenuExample();
        	  sysMenuExample.createCriteria().andIdIn(menuIdList);
    	  }
      }
      List<SysMenu> menuList = sysMenuMapper.selectByExample(sysMenuExample);
      if (menuList != null)
      {
        Map<Integer, SysMenu> menuMap = new HashMap<Integer, SysMenu>();
        for (SysMenu menu : menuList) {
          menuMap.put(menu.getId(), menu);
        }
        for (SysMenu menu : menuList)
        {
          Integer pid = menu.getPid();
          if (pid.intValue() != 0)
          {
            SysMenu parent = (SysMenu)menuMap.get(pid);
            parent.addSubMenu(menu);
          }
          else
          {
            resultMenu.add(menu);
          }
        }
      }
      result.setData(resultMenu);
    }
    result.setMessage("success");
    
    return result;
  }


}
