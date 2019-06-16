package com.telrob.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telrob.common.entity.AppAttribute;
import com.telrob.common.entity.AppAttributeExample;
import com.telrob.common.service.AppAttributeService;
import com.telrob.common.service.BaseService;
@Controller
@RequestMapping("/appAttribute")
public class AppAttributeController extends BaseController<AppAttribute, AppAttributeExample, Integer>{

	@Autowired
	private AppAttributeService sppAttributeService;
	@Override
	public BaseService<AppAttribute, AppAttributeExample, Integer> getBaseService() {
		return sppAttributeService;
	}

}
