package com.telrob.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telrob.common.entity.AppDevice;
import com.telrob.common.entity.AppDeviceExample;
import com.telrob.common.mapper.AppDeviceMapper;
import com.telrob.common.mapper.BaseMapper;

@Service
public class AppDeviceService extends BaseService<AppDevice, AppDeviceExample, Integer> {
	@Autowired
	private AppDeviceMapper appDeviceMapper;
	@Override
	public BaseMapper<AppDevice, AppDeviceExample, Integer> getMapper() {
		return appDeviceMapper;
	}

}
