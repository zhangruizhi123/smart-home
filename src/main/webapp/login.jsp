<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
response.setDateHeader("Expires", 0);    
response.setHeader("Cache-Control", "no-cache");    
response.setHeader("Pragma", "no-cache"); 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>智能家居|登录</title>
  <!-- iCheck -->
  <link rel="stylesheet" href="<%=path %>/admin-lte/plugins/iCheck/square/blue.css">
	<jsp:include page="/css.jsp" />
  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="#"><b>智能家居</b></a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg" style="color:#f00;">${login_msg}</p>

    <form action="<%=path %>/login.do" method="post">
      <div class="form-group has-feedback">
        <input type="text" name="userName" class="form-control" placeholder="账号">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="password" class="form-control" placeholder="密码">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> 记住密码
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
    <a href="#">忘记密码了？</a><br>
    <a href="#" class="text-center">注册</a>

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
<jsp:include page="/js.jsp" />
<script src="<%=path %>/admin-lte/plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
</body>
</html>