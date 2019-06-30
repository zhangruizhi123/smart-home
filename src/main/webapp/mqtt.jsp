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
<title>智能家居管理系统</title>
<link rel="shortcut icon" href="<%=path%>/img/favicon.ico" />
<jsp:include page="/css.jsp" />
<script type="text/javascript" src="<%=path%>/js/mqtt.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/echarts.min.js"></script>
</head>
<body>
	<div class="content">
		<div class="box box-info">
			<div class="box-header with-border">
				<h3 class="box-title">设备调试</h3>
			</div>
			<div class="box-body">
				<form action="" class="form-horizontal">
					<div class="form-group">
						<div class="col-sm-12" >
							
						</div>
						<button id="switch" class="btn btn-block btn-success btn-lg col-sm-6">
						<i class="glyphicon glyphicon-play-circle"></i>
						开关
						</button>
						
					</div>
					<div class="form-group">
						<div class="col-sm-6" id="main" style="height:300px;"></div>
						<div class="col-sm-6" id="temp" style="height:300px;"></div>
					</div>
				 <!-- textarea -->
			        <div class="form-group visible-md" >
			          <label class="col-sm-2 control-label">设备属性</label>
			          <div class="col-sm-8">
			          	<textarea id="text" class="form-control" rows="5" placeholder="请输入属性的json字符串"></textarea>
			          </div>
			          <div class="col-sm-2">
			          	<a class="btn btn-success" id="send">发送</a>
			          </div>
			        </div>
			        <div class="form-group visible-md">
			          <label>日志信息:</label>
			          <div id="log" style="padding:5px;height:200px;border:1px solid #999;overflow: scroll;">
			          </div>
			        </div>
		         </form>
			</div>
			<div class="box-footer"></div>
		</div>
		 
	</div>

</body>
<jsp:include page="/js.jsp" />
<script type="text/javascript">
// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));
var myChart2 = echarts.init(document.getElementById('temp'));

// 指定图表的配置项和数据
var option = {
		tooltip : {
			formatter: "{a} <br/>{b} : {c}℃"
		},
		toolbox: {
			/*
			feature: {
				restore: {},
				saveAsImage: {}
			}
			*/
		},
		series: [
			{
				name: '温度',
				type: 'gauge',
				detail: {formatter:'{value}℃'},
				data: [{value: 30, name: '当前温度'}]
			}
		]
	};
	
var option2 = {
		tooltip : {
			formatter: "{a} <br/>{b} : {c}%"
		},
		toolbox: {
			/*
			feature: {
				restore: {},
				saveAsImage: {}
			}
			*/
		},
		series: [
			{
				name: '湿度',
				type: 'gauge',
				detail: {formatter:'{value}%'},
				data: [{value: 30, name: '当前湿度'}]
			}
		]
	};

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);
myChart2.setOption(option2);


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
		//$("#err").html('正在重连:'+error);
	    console.log('正在重连:', error)
	});
	
	client.on('error', function(error) {
		//$("#err").html('连接失败:'+error);
	    console.log('连接失败:', error)
	});
	
	// 监听接收消息事件
	client.on('message', function(topic, message){
		var msg=message.toString();
		console.log(msg.slice(16,18));
		console.log(msg.slice(18,20));
		option.series[0].data[0].value=msg.slice(16,18);
		myChart.setOption(option,true);
		option2.series[0].data[0].value=msg.slice(18,20);
		myChart2.setOption(option2,true);
		$("#log").append("<div>"+message.toString()+"</div>");
		console.log('收到来自', topic, '的消息', message.toString())
	});
	// 正确示例
	client.on('connect', function(e){
		$("#err").html('成功连接服务器');
		console.log('成功连接服务器')
		// 订阅一个主题
		client.subscribe('/pub/'+getParam("topic"), { qos: 1 }, function(error) {
			if (!error) {
				console.log('订阅成功')
			}
		});
		
	});
	
	$(function(){
		$("#send").click(function(){
			client.publish('/sub/'+getParam("topic"), $("#text").val(), { qos: 0, rein: false }, function(error) {
				console.log(error || '发布成功')
			});
		});
		$("#switch").click(function(){
			client.publish('/sub/'+getParam("topic"), "hello world", { qos: 0, rein: false }, function(error) {
			});
		});
	});
	
	function getParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) return unescape(r[2]); return null;
	}
</script>
</html>