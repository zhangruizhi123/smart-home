package com.telrob.common.bean;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telrob.common.mapper.SysUserMapper;

/**
 * 对mqtt过来的消息进行处理
 * @author telrob
 *
 */
@Component
public class MqttMessageProcess implements MqttCallback{

	@Autowired
	private SysUserMapper sysUserMapper;
	
	public void connectionLost(Throwable cause) {
		
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("topic:"+topic);
		System.out.println("content:"+message);
	}

	public void deliveryComplete(IMqttDeliveryToken token) {
		
	}

}
