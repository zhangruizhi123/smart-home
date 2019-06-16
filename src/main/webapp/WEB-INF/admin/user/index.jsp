<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>智能家居管理系统</title>
<jsp:include page="/css.jsp" />
<style>
.wrapper .my-header{
	background-color:#333;
	color:#fff;
	font-size:16px;
}
.wrapper .my-header ul li{
	float: left;
	display:inline-block;
	border:1px solid #555;
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini" >
  <div class="wrapper">
	<header class="my-header">
		<ul>
			<li>${user_loginedd.name }</li>
			<li>111</li>
		</ul>
	</header>
  </div>
</body>
<jsp:include page="/js.jsp" />
<script type="text/javascript">
</script>
</html>