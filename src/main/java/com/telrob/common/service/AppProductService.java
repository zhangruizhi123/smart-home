package com.telrob.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telrob.common.entity.AppProduct;
import com.telrob.common.entity.AppProductExample;
import com.telrob.common.mapper.AppProductMapper;
import com.telrob.common.mapper.BaseMapper;

@Service
public class AppProductService extends BaseService<AppProduct, AppProductExample, Integer> {

	@Autowired
	private AppProductMapper appProductMapper;
	@Override
	public BaseMapper<AppProduct, AppProductExample, Integer> getMapper() {
		return appProductMapper;
	}

}
