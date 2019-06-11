package com.telrob.common.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telrob.common.entity.SysUser;
import com.telrob.common.entity.SysUserExample;
import com.telrob.common.mapper.SysUserMapper;
import com.telrob.common.utils.StringUtils;

@Service
public class LoginService{
  @Autowired
  private SysUserMapper sysUserMapper;
  
  public String login(String userName, String password, HttpServletRequest request){
    HttpSession session = request.getSession();
    SysUserExample sysUserExample = new SysUserExample();
    sysUserExample.createCriteria().andMobileEqualTo(userName);
    List<SysUser> userList = sysUserMapper.selectByExample(sysUserExample);
    if ((userList == null) || (userList.size() < 1)){
      session.setAttribute("login_msg", "用户名不存在");
      return "redirect:/login.jsp";
    }
    SysUser user = (SysUser)userList.get(0);
    String pwd = StringUtils.MD5(password);
    if (pwd.equals(user.getPassword())){
      session.setAttribute("login_msg", "");
      session.setAttribute("user_loginedd", user);
      user.setModityTime(new Date());
      user.setIp(getIpAddr(request));
      sysUserMapper.updateByPrimaryKeySelective(user);
      
      return "redirect:/view/index.htmls";
    }
    session.setAttribute("login_msg", "用户名或者密码错误");
    return "redirect:/login.jsp";
  }
  
  public String getIpAddr(HttpServletRequest request) {  
	    String ip = request.getHeader("x-forwarded-for");  
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("Proxy-Client-IP");  
	    }  
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("WL-Proxy-Client-IP");  
	    }  
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getRemoteAddr();  
	    }  
	    return ip;  
	}
}
