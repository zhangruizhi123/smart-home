package com.telrob.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.telrob.common.entity.BaseExample;

public  interface BaseMapper<Entity, Example, Key>{
  public  long countByExample(Example paramExample);
  
  public  int deleteByExample(Example paramExample);
  
  public  int deleteByPrimaryKey(Key paramKey);
  
  public  int insert(Entity paramEntity);
  
  public  int insertSelective(Entity paramEntity);
  
  public  List<Entity> selectByExample(Example paramExample);
  
  public  Entity selectByPrimaryKey(Key paramKey);
  
  public  int updateByExampleSelective(Entity paramEntity, Example paramExample);
  
  public  int updateByExample(Entity paramEntity, Example paramExample);
  
  public  int updateByPrimaryKeySelective(Entity paramEntity);
  
  public  int updateByPrimaryKey(Entity paramEntity);
  
  @SelectProvider(type=SelectBySqlParam.class,method="selectSqlWidthParam")
  public List<Entity>selectWidthParam(BaseExample baseExample,Class<Entity> cls);
}
