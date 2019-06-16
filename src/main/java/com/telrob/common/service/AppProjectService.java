package com.telrob.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telrob.common.entity.AppProject;
import com.telrob.common.entity.AppProjectExample;
import com.telrob.common.mapper.AppProjectMapper;
import com.telrob.common.mapper.BaseMapper;
@Service
public class AppProjectService extends BaseService<AppProject, AppProjectExample, Integer> {

	@Autowired
	private AppProjectMapper appProjectMapper;
	@Override
	public BaseMapper<AppProject, AppProjectExample, Integer> getMapper() {
		return appProjectMapper;
	}

}
