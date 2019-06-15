package com.telrob.common.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telrob.common.bean.ResponseResult;
import com.telrob.common.entity.SysRoleMenu;
import com.telrob.common.entity.SysRoleMenuExample;
import com.telrob.common.mapper.BaseMapper;
import com.telrob.common.mapper.SysRoleMenuMapper;

@Service
public class SysRoleMenuService extends BaseService<SysRoleMenu, SysRoleMenuExample, Integer> {

	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;
	@Override
	public BaseMapper<SysRoleMenu, SysRoleMenuExample, Integer> getMapper() {
		// TODO Auto-generated method stub
		return sysRoleMenuMapper;
	}
	public ResponseResult findByMenuId(Integer menuId) {
		ResponseResult result=new ResponseResult();
		result.setCode(0);
		SysRoleMenuExample sysRoleMenuExample=new SysRoleMenuExample();
		sysRoleMenuExample.createCriteria().andMenuIdEqualTo(menuId);
		List<SysRoleMenu> list=sysRoleMenuMapper.selectByExample(sysRoleMenuExample);
		result.setData(list);
		result.setMessage("ok");
		return result;
	}
	public ResponseResult updateRoleMenus(Integer menuId,Integer[] roleIds,Integer[]uroles) {
		ResponseResult result=new ResponseResult();
		if(menuId!=null) {
			//选择的角色处理
			if(roleIds!=null&&roleIds.length>0) {
				for(Integer role:roleIds) {
					SysRoleMenuExample sysRoleMenuExample=new SysRoleMenuExample();
					sysRoleMenuExample
					.createCriteria()
					.andMenuIdEqualTo(menuId)
					.andRoleIdEqualTo(role);
					//当不存在时插入
					if(sysRoleMenuMapper.countByExample(sysRoleMenuExample)<1) {
						SysRoleMenu sysRoleMenu=new SysRoleMenu();
						sysRoleMenu.setMenuId(menuId);
						sysRoleMenu.setRoleId(role);
						sysRoleMenu.setModifyTime(new Date());
						sysRoleMenuMapper.insertSelective(sysRoleMenu);
					}
				}
			}
			//未选择的角色处理
			if(uroles!=null&&uroles.length>0) {
				for(Integer role:uroles) {
					SysRoleMenuExample sysRoleMenuExample=new SysRoleMenuExample();
					sysRoleMenuExample
					.createCriteria()
					.andMenuIdEqualTo(menuId)
					.andRoleIdEqualTo(role);
					//当存在时删除
					List<SysRoleMenu> list=sysRoleMenuMapper.selectByExample(sysRoleMenuExample);
					if(list!=null&&list.size()>0) {
						sysRoleMenuMapper.deleteByPrimaryKey(list.get(0).getId());
					}
				}
			}
		}else {
			result.setCode(201);
			result.setMessage("请选择菜单");
		}
		return result;
	}

}
