package com.etoak.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloProduce {

	public static void main(String[] args) throws JMSException {
	// 创建
	ConnectionFactory factory = new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
	//创建connection
	Connection connection = factory.createConnection();
	connection.start();
	//session               是否启用事务         客户端签收方式
	Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	//创建Destination·   消息名字helloQueue     名字不存在就是queue
	Queue helloQueue = session.createQueue("hi");
	
	//通过session创建生产者  吧消息的名字放进去
	MessageProducer producer = session.createProducer(helloQueue);
	//session创建消息
	TextMessage msage = session.createTextMessage("这是第一和 hi消息");
	//生产者发送消息发送消息
	producer.send(msage);
	//关闭资源
	producer.close();
	connection.close();
	session.close();
	System.out.println("ok");
		
		
	}

}




















