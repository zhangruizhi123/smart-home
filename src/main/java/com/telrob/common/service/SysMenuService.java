package com.telrob.common.service;

import com.telrob.common.bean.ResponseResult;
import com.telrob.common.entity.SysMenu;
import com.telrob.common.mapper.SysMenuMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysMenuService
{
  @Autowired
  private SysMenuMapper sysMenuMapper;
  
  public ResponseResult listMenu(Integer id)
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
      List<SysMenu> menuList = this.sysMenuMapper.selectByExample(null);
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
