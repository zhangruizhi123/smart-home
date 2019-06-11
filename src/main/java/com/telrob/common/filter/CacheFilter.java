package com.telrob.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CacheFilter implements Filter {
  public void destroy() {}
  
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException
  {
    HttpServletResponse resp = (HttpServletResponse)response;
    resp.setDateHeader("Expires", 0L);
    resp.setHeader("Cache-Control", "no-cache");
    resp.setHeader("Pragma", "no-cache");
    chain.doFilter(request, response);
  }
  
  public void init(FilterConfig fConfig)
    throws ServletException
  {}
}
