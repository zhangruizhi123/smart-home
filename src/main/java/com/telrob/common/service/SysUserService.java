package com.telrob.common.service;

import com.telrob.common.entity.SysUser;
import com.telrob.common.entity.SysUserExample;
import com.telrob.common.mapper.BaseMapper;
import com.telrob.common.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService extends BaseService<SysUser, SysUserExample, Integer>{
  @Autowired
  private SysUserMapper sysUserMapper;
  
  public BaseMapper<SysUser, SysUserExample, Integer> getMapper(){
    return this.sysUserMapper;
  }
}
