package com.telrob.common.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.bcel.internal.generic.SIPUSH;
import com.telrob.common.entity.BaseExample;
import com.telrob.common.entity.SysIcon;
import com.telrob.common.mapper.SysIconMapper;

@Controller
@RequestMapping({"test"})
public class TestController
{
  private Logger logger = Logger.getLogger(TestController.class);
  @Autowired
  private SysIconMapper sysIconMapper;
  @RequestMapping({"/index.do"})
  @ResponseBody
  public Object test()
  {
    this.logger.info("#############");
    return "";
  }
  
  @RequestMapping("tt")
  @ResponseBody
  public Object test2() throws ParseException{
	  List<Date>tm=new ArrayList<Date>();
	  SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  tm.add(fmt.parse("2019-06-11 21:10:44"));
	  BaseExample b=new BaseExample();
	  b.createCriteria().andItemIn("modifyTime", tm);
	  return sysIconMapper.selectWidthParam(b, SysIcon.class);
  }
}
