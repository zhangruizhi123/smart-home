package com.telrob.common.bean;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;

public class Mqtt {
	private MqttClient client;
	
	public Mqtt(String host,String clientId,String userName,String password,final long time) throws MqttException {
		client = new MqttClient(host, clientId);
        MqttConnectOptions conOptions = new MqttConnectOptions();
        conOptions.setUserName(userName);
        conOptions.setPassword(password.toCharArray());
        conOptions.setCleanSession(true);
        client.connect(conOptions);
        //开启一个线程监听运行状态，断开自动重连
        /*
        new Thread() {
        	public void run() {
        		while(true) {
        			
        			try {
        				System.out.println(client.isConnected());
        				if(client!=null&&!client.isConnected()){
        		            client.reconnect();
        		            System.out.println("@@@@@");
        		        }
        				System.out.println("......");
						Thread.sleep(time);
					} catch (Exception e) {
						e.printStackTrace();
					}
        		}
        	};
        }.start();
        */
        System.out.println("++++++++++++++");
        subscribe("test", new MqttCallback() {
			
			public void messageArrived(String topic, MqttMessage message) throws Exception {
				// TODO Auto-generated method stub
				System.out.println(client.isConnected());
				 System.out.println("MQTT Rece:" + message.toString());
				
			}
			
			public void deliveryComplete(IMqttDeliveryToken token) {
				// TODO Auto-generated method stub
				
			}
			
			public void connectionLost(Throwable cause) {
				// TODO Auto-generated method stub
				
			}
		});
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
	
	public void subscribe(String subTopic,MqttCallback callback) throws MqttException {
		MqttClient client=getClient();
		client.setCallback(callback);
		client.subscribe(subTopic, 0);
	}
}
