package com.telrob.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telrob.common.entity.SysIcon;
import com.telrob.common.entity.SysIconExample;
import com.telrob.common.service.BaseService;
import com.telrob.common.service.SysIconService;

@Controller
@RequestMapping("sysIcon")
public class SysIconController extends BaseController<SysIcon, SysIconExample, Integer> {

	@Autowired
	private SysIconService sysIconService;
	@Override
	public BaseService<SysIcon, SysIconExample, Integer> getBaseService() {
		return sysIconService;
	}
}
