package com.telrob.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telrob.common.entity.SysIcon;
import com.telrob.common.entity.SysIconExample;
import com.telrob.common.mapper.BaseMapper;
import com.telrob.common.mapper.SysIconMapper;

@Service
public class SysIconService extends BaseService<SysIcon, SysIconExample, Integer> {

	@Autowired
	private SysIconMapper sysIconMapper;
	@Override
	public BaseMapper<SysIcon, SysIconExample, Integer> getMapper() {
		// TODO Auto-generated method stub
		return sysIconMapper;
	}

}
