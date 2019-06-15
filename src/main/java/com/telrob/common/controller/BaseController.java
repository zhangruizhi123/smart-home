package com.telrob.common.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.telrob.common.bean.RequestParams;
import com.telrob.common.bean.ResponseResult;
import com.telrob.common.entity.BaseExample;
import com.telrob.common.entity.SysIconExample;
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
  
  /**
   * 分页查询
   * @param page
   * @param rows
   * @return
   */
  
  @RequestMapping("/listPageParams")
  @ResponseBody
  public ResponseResult listPageParams(Entity entity,Integer start, Integer length,Integer draw,String orderName,String orderRole,String param){
	  ResponseResult responseResult = new ResponseResult();
	    try{
	      if ((start == null) || (start.intValue() < 0)) {
	    	  start = 0;
	      }
	      BaseExample baseExample=null;
	      if(param!=null&&!"".equals(param)) {
	    	  RequestParams paramObj=JSONObject.parseObject(param, RequestParams.class);
	    	  if(paramObj!=null) {
	    		  baseExample=paramObj.getExample(entity.getClass());
	    	  }else {
	    		  baseExample=new BaseExample(entity.getClass());
	    	  }
	      }else {
	    	  baseExample=new BaseExample(entity.getClass());
	      }
	      //设置排序
	      String colName=baseExample.getTableColumn(orderName);
	      if(colName!=null) {
	    	  baseExample.setOrderByClause(colName+" "+orderRole);
	      }
	      //当不加分页时候查询全部
	      if(length!=null) {
	    	  PageHelper.offsetPage(start, length);
	      }
	      List<Entity> list = getBaseService().selectWithParam(baseExample);
	      
	      responseResult.setStart(start);
	      responseResult.setDraw(draw);
	      if (list == null){
	    	  responseResult.setiTotalDisplayRecords(0L);
	    	  responseResult.setiTotalRecords(0L);
	      }else{
	    	  if(length!=null) {
	    		  PageInfo<Entity> pageInfo = new PageInfo<Entity>(list);
	    		  responseResult.setLength((int)pageInfo.getTotal());
	    		  responseResult.setData(pageInfo.getList());
	    		  responseResult.setiTotalDisplayRecords(pageInfo.getTotal());
	    		  responseResult.setiTotalRecords(pageInfo.getTotal());
	    	  }else {
	    		  responseResult.setLength(list.size());
	    		  responseResult.setData(list);
	    		  responseResult.setiTotalDisplayRecords((long)list.size());
	    		  responseResult.setiTotalRecords((long)list.size());
	    	  }
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
