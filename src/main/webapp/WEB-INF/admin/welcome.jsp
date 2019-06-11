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
<title>Insert title here</title>
<jsp:include page="/css.jsp" />
</head>
<body >
	
	<div style="margin:20px;text-align:center;">
	<h1>欢迎使用智能家居管理系统</h1>
	</div>
</body>
<jsp:include page="/js.jsp" />
<script type="text/javascript">
	
</script>
</html>