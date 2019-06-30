<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath(); 
// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）: 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>智能家居管理系统</title>
<link rel="shortcut icon" href="<%=path%>/img/favicon.ico" />
<jsp:include page="/css.jsp" />
<jsp:include page="/js.jsp" />
</head>
<body>
	
<div class="container">
	<div style="text-align:center;">
		<h1>欢迎进入智能家居管理系统</h1>
		<a href="<%=path %>/login.jsp">登录</a>
	</div>
	<img alt="" class="center-block" src="<%=path %>/img/smart.jpg">
	<div style="text-align:center;">
		<span>QQ:</span>
		<span>1852654131</span>
	</div>
</div>

</body>
<script type="text/javascript">
$(document).ready(function() {
   
});
</script>
</html>