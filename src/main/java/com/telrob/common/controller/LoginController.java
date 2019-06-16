package com.telrob.common.controller;

import com.telrob.common.service.LoginService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class LoginController
{
  @Autowired
  private LoginService loginService;
  
  @RequestMapping({"/login"})
  public String login(String userName, String password, HttpServletRequest request)
  {
    HttpSession session = request.getSession();
    String result = "";
    try
    {
      if ((userName == null) || (userName.equals("")))
      {
        session.setAttribute("login_msg", "用户名不能为空");
        return "redirect:/login.jsp";
      }
      if ((password == null) || (password.equals("")))
      {
        session.setAttribute("login_msg", "密码不能为空");
        return "redirect:/login.jsp";
      }
      result = this.loginService.login(userName, password, request);
    }
    catch (Exception e)
    {
      session.setAttribute("login_msg", e.getMessage());
      return "redirect:/login.jsp";
    }
    return result;
  }
  
  @RequestMapping({"/logout"})
  public String logout(HttpServletRequest request) {
	  HttpSession session=request.getSession();
	  session.setMaxInactiveInterval(1);
	  return "redirect:/login.jsp";
  }
  
  @RequestMapping({"/view/{url}"})
  public String toPage(@PathVariable String url, HttpSession session)
  {
    Object obj = session.getAttribute("user_loginedd");
    if (obj == null) {
      return "redirect:/login.jsp";
    }
    String path = url.replaceAll("\\.", "/");
    return "/admin/" + path;
  }
}
