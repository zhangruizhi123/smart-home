package com.telrob.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telrob.common.entity.AppProject;
import com.telrob.common.entity.AppProjectExample;
import com.telrob.common.service.AppProjectService;
import com.telrob.common.service.BaseService;

@Controller
@RequestMapping("/appProject")
public class AppProjectController extends BaseController<AppProject, AppProjectExample, Integer> {

	@Autowired
	private AppProjectService appProjectService;
	
	@Override
	public BaseService<AppProject, AppProjectExample, Integer> getBaseService() {
		return appProjectService;
	}

}
