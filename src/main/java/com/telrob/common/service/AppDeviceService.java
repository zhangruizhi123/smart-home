package com.telrob.common.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telrob.common.bean.ResponseResult;
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
	public ResponseResult deviceLogin(String productKey, String mac) {
		ResponseResult result=new ResponseResult();
		AppDevice appDevice=appDeviceMapper.deviceLogin(productKey, mac);
		if(appDevice!=null) {
			appDevice.setState(3);
			appDevice.setModifyTime(new Date());
			appDeviceMapper.updateByPrimaryKeySelective(appDevice);
			result.setCode(0);
			result.setMessage("ok");
			Map<String,String>rr=new HashMap<String,String>();
			rr.put("pub", "/pub/"+appDevice.getTopic());
			rr.put("sub", "/sub/"+appDevice.getTopic());
			result.setData(rr);
		}else {
			result.setCode(201);
			result.setMessage("请检查产品中是否录入该设备");
		}
		return result;
	}

}
