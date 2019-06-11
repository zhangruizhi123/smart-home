package com.telrob.common.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.telrob.common.bean.ResponseResult;
import com.telrob.common.service.BaseService;

public abstract class BaseController<Entity, Example, Key>{
  public abstract BaseService<Entity, Example, Key> getBaseService();
	  
  /**
   * 查询
   * @param id
   * @return
   */
  @RequestMapping("/findByPrimaryKey")
  @ResponseBody
  public ResponseResult findByPrimaryKey(Key id){
    ResponseResult responseResult = new ResponseResult();
    try
    {
      Entity entity = getBaseService().findByPrimaryKey(id);
      responseResult.setCode(0);
      responseResult.setMessage("查询成功");
      responseResult.setData(entity);
    }catch (Exception e){
      responseResult.setCode(101);
      responseResult.setMessage(e.getMessage());
    }
    return responseResult;
  }
  
  /**
   * 删除
   * @param id
   * @return
   */
  @RequestMapping("/deleteByPrimaryKey")
  @ResponseBody
  public ResponseResult deleteByPrimaryKey(Key id){
    ResponseResult responseResult = new ResponseResult();
    try {
      int result = getBaseService().deleteByPrimaryKey(id);
      if(result<1) {
    	  responseResult.setCode(201);
    	  responseResult.setMessage("删除失败");
      responseResult.setData(result);
  }else {
	  responseResult.setCode(0);
	  responseResult.setMessage("删除成功");
	      responseResult.setData(result);
      }
     
    }catch (Exception e){
      responseResult.setCode(101);
      responseResult.setMessage(e.getMessage());
    }
    return responseResult;
  }
  
  /**
   * 插入
   * @param item
   * @return
   */
  @RequestMapping("/insertSeletive")
  @ResponseBody
  public ResponseResult insertSeletive(@RequestBody Entity item){
    ResponseResult responseResult = new ResponseResult();
    try {
      int result = getBaseService().insertSelective(item);
      if(result<1) {
    	  responseResult.setCode(201);
    	  responseResult.setMessage("插入失败");
      responseResult.setData(result);
  }else {
	  responseResult.setCode(0);
	  responseResult.setMessage("插入成功");
	      responseResult.setData(result);
      }
    }catch (Exception e){
      responseResult.setCode(101);
      responseResult.setMessage(e.getMessage());
    }
    return responseResult;
  }
  
  
  /**
   * 根据主键更新
   * @param item
   * @return
   */
  @RequestMapping("/updateByPrimaryKey")
  @ResponseBody
  public ResponseResult updateByPrimaryKey(@RequestBody Entity item){
    ResponseResult responseResult = new ResponseResult();
    try {
      int result = getBaseService().updatePrymaryKey(item);
      if(result<1) {
    	  responseResult.setCode(201);
    	  responseResult.setMessage("更新失败");
      responseResult.setData(result);
  }else {
	  responseResult.setCode(0);
	  responseResult.setMessage("更新成功");
	      responseResult.setData(result);
      }
    }catch (Exception e){
      responseResult.setCode(101);
      responseResult.setMessage(e.getMessage());
    }
    return responseResult;
  }
  
  
  /**
   * 分页查询
   * @param page
   * @param rows
   * @return
   */
  
  @RequestMapping("/listPageItem")
  @ResponseBody
  public ResponseResult listPageItems(Integer start, Integer length,Integer draw){
    ResponseResult responseResult = new ResponseResult();
    try{
      if ((start == null) || (start.intValue() < 0)) {
    	  start = 0;
      }
      if ((length == null) || (length.intValue() < 1)) {
    	  length = 20;
      }
      PageHelper.offsetPage(start, length);
      List<Entity> list = getBaseService().selectByExcmple(null);
      responseResult.setStart(start);
      responseResult.setDraw(draw);
      if (list == null){
    	  responseResult.setiTotalDisplayRecords(0L);
    	  responseResult.setiTotalRecords(0L);
      }else{
        PageInfo<Entity> pageInfo = new PageInfo<Entity>(list);
        responseResult.setLength((int)pageInfo.getTotal());
        responseResult.setData(pageInfo.getList());
        responseResult.setiTotalDisplayRecords(pageInfo.getTotal());
        responseResult.setiTotalRecords(pageInfo.getTotal());
      }
      responseResult.setCode(0);
      responseResult.setMessage("查询成功");
    }catch (Exception e){
      responseResult.setCode(101);
      responseResult.setMessage(e.getMessage());
    }
    return responseResult;
  }
	  
}
