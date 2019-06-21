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
	private static MqttClient client;
	private long timeout;
	private boolean isConnect=true;
	private MqttConnectOptions conOptions=null;
	
	public Mqtt(String host,String clientId,String userName,String password,final long time) throws MqttException {
		timeout=time;
		client = new MqttClient(host, clientId);
        conOptions = new MqttConnectOptions();
        conOptions.setUserName(userName);
        conOptions.setPassword(password.toCharArray());
        conOptions.setCleanSession(false);
        //conOptions.setConnectionTimeout(10); 
        //conOptions.setKeepAliveInterval(20); 
        //conOptions.setAutomaticReconnect(true);
        client.connect(conOptions);
        System.out.println("+++++++++++++++++++++++");
        System.out.println(client.isConnected());
       
	}
	
	public void init() throws MqttException {
		client.subscribe("111", 0);
		client.setCallback(new MqttCallback() {
				
				public void messageArrived(String topic, MqttMessage message) throws Exception {
					// TODO Auto-generated method stub
					System.out.println("topic:"+topic);
					System.out.println(message);
				}
				
				public void deliveryComplete(IMqttDeliveryToken token) {
					// TODO Auto-generated method stub
					System.out.println("##########deliveryComplete");
				}
				
				public void connectionLost(Throwable cause) {
					// TODO Auto-generated method stub
					System.out.println("::::::connectionLost");
					isConnect=false;
				}
			});
		
		new Thread() {
			@Override
			public void run() {
				while(true) {
					if(isConnect==false) {
						try {
							client.connect(conOptions);
							if(client.isConnected()) {
								client.subscribe("111", 0);
								isConnect=true;
								System.out.println("连接成功");
							}else {
								System.out.println("连接失败");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					try {
						Thread.sleep(1000*5);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}.start();;
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
		client=getClient();
		client.setCallback(callback);
		client.subscribe(subTopic, 0);
	}

}
