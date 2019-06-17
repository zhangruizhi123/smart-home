package com.telrob.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.telrob.common.bean.ResponseResult;
import com.telrob.common.entity.AppProduct;
import com.telrob.common.entity.AppProductExample;
import com.telrob.common.service.AppProductService;
import com.telrob.common.service.BaseService;
import com.telrob.common.utils.StringUtils;

@Controller
@RequestMapping("/appProduct")
public class AppProductController extends BaseController<AppProduct, AppProductExample, Integer> {

	@Autowired
	private AppProductService appProductService;
	@Override
	public BaseService<AppProduct, AppProductExample, Integer> getBaseService() {
		return appProductService;
	}
	
	@RequestMapping("/insertSeletive")
	@ResponseBody
	public ResponseResult insertSeletive(@RequestBody AppProduct item, HttpServletRequest request) {
		item.setProductKey(StringUtils.getUUID());
		return super.insertSeletive(item, request);
	}
}
