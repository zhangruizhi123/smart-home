package com.telrob.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telrob.common.entity.SysRole;
import com.telrob.common.entity.SysRoleExample;
import com.telrob.common.mapper.BaseMapper;
import com.telrob.common.mapper.SysRoleMapper;

@Service
public class SysRoleService extends BaseService<SysRole, SysRoleExample, Integer> {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Override
	public BaseMapper<SysRole, SysRoleExample, Integer> getMapper() {
		return sysRoleMapper;
	}

}
