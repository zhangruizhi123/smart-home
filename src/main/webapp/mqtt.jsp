<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
ResourceBundle res = ResourceBundle.getBundle("mqtt");
String ws = res.getString("mqtt.websockets");
String path = request.getContextPath(); 
// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）: 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<title>Insert title here</title>
<script type="text/javascript" src="<%=path %>/admin-lte/bower_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/mqtt.min.js"></script>
</head>
<body>
	<div>
		<div style="color:#F00" id="err"></div>
		<textarea rows="" cols="10" id="text"></textarea>
		<button id="send">发送</button>
		<div id="msg"></div>
	</div>

</body>
<script type="text/javascript">
	if( typeof(WebSocket) != "function" ) {
	    alert("您的浏览器不支持Websocket通信协议，请更换浏览器为Chrome或者Firefox再次使用！")
	}
	// 连接选项
	const options = {
	      connectTimeout: 4000, // 超时时间
	      // 认证信息
	      clientId: 'emqx-connect-via-websocket'+Math.random(),
	      username: 'emqx-connect-via-websocket',
	      password: 'emqx-connect-via-websocket',
	};
	const client = mqtt.connect('<%=ws%>', options)
	client.on('reconnect', function(error) {
		$("#err").html('正在重连:'+error);
	    console.log('正在重连:', error)
	});
	
	client.on('error', function(error) {
		$("#err").html('连接失败:'+error);
	    console.log('连接失败:', error)
	});
	
	// 监听接收消息事件
	client.on('message', function(topic, message){
		$("#msg").append("<p>"+message.toString()+"</p>");
		console.log('收到来自', topic, '的消息', message.toString())
	});
	// 正确示例
	client.on('connect', function(e){
		$("#err").html('成功连接服务器');
		console.log('成功连接服务器')
		// 订阅一个主题
		client.subscribe('hello', { qos: 1 }, function(error) {
			if (!error) {
				console.log('订阅成功')
			}
		});
		
	});
	
	$(function(){
		$("#send").click(function(){
			client.publish('hello', $("#text").val(), { qos: 0, rein: false }, function(error) {
				console.log(error || '发布成功')
			});
		});
	});
</script>
</html>