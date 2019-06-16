package com.telrob.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telrob.common.entity.AppDeviceRecode;
import com.telrob.common.entity.AppDeviceRecodeExample;
import com.telrob.common.service.AppDeviceRecodeService;
import com.telrob.common.service.BaseService;

@Controller
@RequestMapping("/appDeviceRecode")
public class AppDeviceRecodeController extends BaseController<AppDeviceRecode, AppDeviceRecodeExample, Integer> {

	@Autowired
	private AppDeviceRecodeService appDeviceRecodeService;
	@Override
	public BaseService<AppDeviceRecode, AppDeviceRecodeExample, Integer> getBaseService() {
		return appDeviceRecodeService;
	}

}
