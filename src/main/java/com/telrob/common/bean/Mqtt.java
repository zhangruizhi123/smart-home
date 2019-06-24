package com.telrob.common.bean;

import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;

public class Mqtt {
	private static MqttClient client;
	private static long timeout;
	private static boolean isConnect=true;
	private static MqttConnectOptions conOptions=null;
	private static String topic="";
	public Mqtt(String host,String clientId,String userName,String password,final long time,String topic,MqttCallback callback) throws MqttException {
		//当初始化第一次时设置
		if(conOptions==null) {
			this.topic=topic;
			timeout=time;
			conOptions = new MqttConnectOptions();
			conOptions.setUserName(userName);
			conOptions.setPassword(password.toCharArray());
			conOptions.setCleanSession(false);
			//conOptions.setConnectionTimeout(10); 
			//conOptions.setKeepAliveInterval(20); 
			//conOptions.setAutomaticReconnect(true);
		}
		if(client==null) {
			client = new MqttClient(host, clientId+UUID.randomUUID().toString());
			client.connect(conOptions);
			client.subscribe(topic, 0);
			if(callback!=null) {
				client.setCallback(callback);
			}
		}
	}
	/**
	 * 开启线程监听状态
	 * @throws MqttException
	 */
	public void init() throws MqttException {
		new Thread() {
			@Override
			public void run() {
				while(true) {
					if(client.isConnected()==false) {
						try {
							client.connect(conOptions);
							if(client.isConnected()) {
								client.subscribe(topic, 0);
								isConnect=true;
								System.out.println("连接成功");
							}else {
								System.out.println("连接失败");
							}
						} catch (Exception e) {
							//e.printStackTrace();
						}
					}
					try {
						Thread.sleep(timeout);
					} catch (Exception e) {
						//e.printStackTrace();
					}
				}
			}
		}.start();
		
	}
	public MqttClient getClient() throws MqttException {
		if(!client.isConnected()){
            client.reconnect();
        }
		return client;
	}
	
	/**
	 * 发布
	 * @throws MqttException
	 */
	public boolean publish(String topic,String sendMsg) throws MqttException {
		MqttTopic top=getClient().getTopic(topic);
		MqttMessage message = new MqttMessage(sendMsg.getBytes());
		message.setQos(0);
		MqttDeliveryToken tocken=top.publish(message);
		return tocken.isComplete();
	}
	
}
