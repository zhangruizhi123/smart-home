package com.telrob.common.service;

import com.telrob.common.mapper.BaseMapper;
import java.util.List;

public abstract class BaseService<Entity, Example, Key>
{
  public abstract BaseMapper<Entity, Example, Key> getMapper();
  
  public Entity findByPrimaryKey(Key id)
  {
    return (Entity)getMapper().selectByPrimaryKey(id);
  }
  
  public int deleteByPrimaryKey(Key id)
  {
    return getMapper().deleteByPrimaryKey(id);
  }
  
  public int insertSelective(Entity entity)
  {
    return getMapper().insertSelective(entity);
  }
  
  public int insert(Entity entity)
  {
    return getMapper().insert(entity);
  }
  
  public int updatePrymaryKey(Entity entity)
  {
    return getMapper().updateByPrimaryKey(entity);
  }
  
  public List<Entity> selectByExcmple(Example example)
  {
    return getMapper().selectByExample(example);
  }
}
