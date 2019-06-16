package com.telrob.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telrob.common.entity.AppDevice;
import com.telrob.common.entity.AppDeviceExample;
import com.telrob.common.service.AppDeviceService;
import com.telrob.common.service.BaseService;

@Controller
@RequestMapping("/appDevice")
public class AppDeviceController extends BaseController<AppDevice, AppDeviceExample, Integer> {

	@Autowired
	private AppDeviceService appDeviceService;
	@Override
	public BaseService<AppDevice, AppDeviceExample, Integer> getBaseService() {
		return appDeviceService;
	}

}
