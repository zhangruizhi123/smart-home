package com.telrob.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/**
 * 
 * 功能描述：MQTT测试
 * 创建人： mao2080@sina.com
 * 创建时间：2017年7月4日 下午5:08:59
 * 修改人： mao2080@sina.com
 * 修改时间：2017年7月4日 下午5:08:59
 */
public class MQTTTest_tcp {

    /**MQTT服务端ip及端口*/
    private static String host = "tcp://127.0.0.1:1883";
    /**账号*/
    private static String username = "li2080";
    /**密码*/
    private static String password = "123";
    /**订阅的主题*/
    private static String subTopic = "a/b/c";
    /**clientID*/
    private static String clientId = "li2080";
    /**发布的主题*/
    private static String pubTopic = "a/b/c";
    /**MQTT-Client*/
    private static MqttClient client;
    
    /**MQTT-Client*/
    private static int uuid = 0;

    /**
     * @throws InterruptedException 
     * @throws MqttException */
    public static void main(String[] args) throws InterruptedException, MqttException {
        
        // 订阅消息的方法
        subscribe();
//        
        publish();
    }

    /**
     * 
     * 描述：订阅信息
     * @author mao2080@sina.com
     * @created 2017年7月4日 下午4:53:47
     * @since 
     * @return
     */
    public static void subscribe() {
        try {
            // 创建MqttClient
            MQTTTest_tcp.getClient().setCallback(new MqttCallback() {

                public void connectionLost(Throwable arg0) {
                    
                }

                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println("MQTT Rece:" + message.toString());
                }

                public void deliveryComplete(IMqttDeliveryToken token) {

                }

            });
            MQTTTest_tcp.getClient().subscribe(subTopic, 0);
            System.out.println("连接状态:" + client.isConnected());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * 描述：获取MqttClient
     * @author mao2080@sina.com
     * @created 2017年7月6日 上午9:56:37
     * @since 
     * @return
     * @throws MqttException
     */
    public static MqttClient getClient() throws MqttException{
        try {
            if(client == null){
                client = new MqttClient(host, clientId);
                MqttConnectOptions conOptions = new MqttConnectOptions();
                conOptions.setUserName(username);
                conOptions.setPassword(password.toCharArray());
                conOptions.setCleanSession(true);
                client.connect(conOptions);
            }
            if(!client.isConnected()){
                client.reconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }

    /**
     * 
     * 描述：发布信息
     * @author mao2080@sina.com
     * @throws MqttException 
     * @created 2017年7月4日 下午4:53:32
     * @since
     */
    public static void publish() throws MqttException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sendMsg = "{time:"+sdf.format(new Date())+", content:11111, from: java console}";
        try {
            MqttTopic topic = MQTTTest_tcp.getClient().getTopic(pubTopic);
            MqttMessage message = new MqttMessage(sendMsg.getBytes());
            message.setQos(0);
            topic.publish(message);
            System.out.println("MQTT Send:" + sendMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}