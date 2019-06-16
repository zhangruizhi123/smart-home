package com.telrob.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telrob.common.entity.AppProduct;
import com.telrob.common.entity.AppProductExample;
import com.telrob.common.service.AppProductService;
import com.telrob.common.service.BaseService;

@Controller
@RequestMapping("/appProduct")
public class AppProductController extends BaseController<AppProduct, AppProductExample, Integer> {

	@Autowired
	private AppProductService appProductService;
	@Override
	public BaseService<AppProduct, AppProductExample, Integer> getBaseService() {
		return appProductService;
	}

}
