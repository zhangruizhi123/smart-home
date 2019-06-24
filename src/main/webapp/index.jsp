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
<title>Insert title here</title>
<script type="text/javascript" src="<%=path%>/js/vue.js"></script>
<script type="text/javascript" src="<%=path%>/js/browserMqtt.min.js"></script>
<jsp:include page="/js.jsp" />
</head>
<body>
	欢迎进入智能家居管理系统
	<input type="text" id="msg" />

</body>
<script type="text/javascript">
//虽然使用的是 MQTT，但底层还是使用 WebSocket 实现的，所以这里的端口需要使用 ActiveMQ 里 WS 的端口 61614，而不是 MQTT 的端口 1883
var client = mqtt.connect('ws://127.0.0.1:9001'); // you add a ws:// url here
client.subscribe('#'); // 订阅 Topic

client.on('message', function(topic, payload) {
	console.log("topic:"+topic);
	console.log(payload);
    //console.log([payload].join('')); // 提取消息需要使用 [].join()
})

client.publish('foo', 'Hello World!'); // 发送消息

// 不停的发送消息进行测试
setInterval(function() {
    client.publish('foo',  'Time: ' + new Date().getTime());
}, 1000);
</script>
</html>