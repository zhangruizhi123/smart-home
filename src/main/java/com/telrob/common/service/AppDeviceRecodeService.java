package com.telrob.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telrob.common.entity.AppDeviceRecode;
import com.telrob.common.entity.AppDeviceRecodeExample;
import com.telrob.common.mapper.AppDeviceRecodeMapper;
import com.telrob.common.mapper.BaseMapper;

@Service
public class AppDeviceRecodeService extends BaseService<AppDeviceRecode, AppDeviceRecodeExample, Integer> {

	@Autowired
	private AppDeviceRecodeMapper appDeviceRecodeMapper;
	@Override
	public BaseMapper<AppDeviceRecode, AppDeviceRecodeExample, Integer> getMapper() {
		return appDeviceRecodeMapper;
	}

}
