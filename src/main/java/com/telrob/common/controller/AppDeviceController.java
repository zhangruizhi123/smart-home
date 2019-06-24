package com.telrob.common.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.telrob.common.bean.ResponseResult;
import com.telrob.common.entity.AppDevice;
import com.telrob.common.entity.AppDeviceExample;
import com.telrob.common.service.AppDeviceService;
import com.telrob.common.service.BaseService;
import com.telrob.common.utils.StringUtils;

@Controller
@RequestMapping("/appDevice")
public class AppDeviceController extends BaseController<AppDevice, AppDeviceExample, Integer> {

	@Autowired
	private AppDeviceService appDeviceService;
	@Override
	public BaseService<AppDevice, AppDeviceExample, Integer> getBaseService() {
		return appDeviceService;
	}
	
	@RequestMapping("/insertSeletive")
	@ResponseBody
	@Override
	public ResponseResult insertSeletive(@RequestBody AppDevice item, HttpServletRequest request) {
		item.setcTime(new Date());
		item.setDeviceSecret(StringUtils.getRandomId());
		item.setTopic(StringUtils.getUUID());
		return super.insertSeletive(item, request);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/deviceLogin")
	@JsonView(ResponseResult.NoPage.class)
	@ResponseBody
	public ResponseResult deviceLogin(String productKey,String mac) {
		ResponseResult responseResult = new ResponseResult();
		try {
			if(productKey==null||"".equals(productKey)) {
				responseResult.setCode(102);
				responseResult.setMessage("请输入productKey");
				return responseResult;
			}
			if(mac==null||"".equals(mac)) {
				responseResult.setCode(103);
				responseResult.setMessage("请输入mac");
				return responseResult;
			}
			responseResult=appDeviceService.deviceLogin(productKey,mac);
			
		}catch(Exception e) {
			responseResult.setCode(101);
			responseResult.setMessage(e.getMessage());
		}
		return responseResult;
	}

}
