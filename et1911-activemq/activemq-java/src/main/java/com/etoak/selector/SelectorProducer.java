package com.etoak.selector;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class SelectorProducer {

	public static void main(String[] args) throws JMSException {
		// 
		ConnectionFactory factory= new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		Connection connection = factory.createConnection();
		connection.start();               //客户端签收 手动签收  通知消息队列 删除队列   只要不签收用于不消费
		Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
		Queue queue = session.createQueue("selector");
		MessageProducer producer = session.createProducer(queue);
		//设置持久化  默认就是持久化
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		
		TextMessage msg = session.createTextMessage("山东易途：趵突泉蓝石大厦");
		//选择器1
		msg.setStringProperty("name", "etoak");
		msg.setIntProperty("age", 21);
		//选择器2
		TextMessage msg2 = session.createTextMessage("济南易途山大路 数码港大厦");
		msg2.setStringProperty("name", "etoak2");
		msg2.setIntProperty("age", 22);
		//发送两条  
		producer.send(msg);
		producer.send(msg2);
		
		producer.close();
		session.close();
		connection.close();
		
	}

}





