package com.telrob.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telrob.common.entity.AppAttribute;
import com.telrob.common.entity.AppAttributeExample;
import com.telrob.common.mapper.AppAttributeMapper;
import com.telrob.common.mapper.BaseMapper;

@Service
public class AppAttributeService extends BaseService<AppAttribute, AppAttributeExample, Integer> {
	@Autowired
	private AppAttributeMapper appAttributeMapper;
	@Override
	public BaseMapper<AppAttribute, AppAttributeExample, Integer> getMapper() {
		return appAttributeMapper;
	}

}
