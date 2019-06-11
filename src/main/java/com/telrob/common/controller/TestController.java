package com.telrob.common.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"test"})
public class TestController
{
  private Logger logger = Logger.getLogger(TestController.class);
  
  @RequestMapping({"/index.do"})
  @ResponseBody
  public Object test()
  {
    this.logger.info("#############");
    return "";
  }
  
  @RequestMapping({"/tt.do"})
  public String test2()
  {
    return "index";
  }
}
