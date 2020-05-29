package com.etoak.config;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSConnectionFactory;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;


/**
 * activeMQ配置
 * @author Administrator
 * 
 * 
 * //可以在RootConfig引入 还可以在 整个容器里面 引进来  springMVCIniti.....
 *@Import(value = {ActiveMQConfig.class})
public class RootConfig
 */
@Configuration
public class ActiveMQConfig {
	
	@Bean
	public ActiveMQConnectionFactory mqFactory() {
		ActiveMQConnectionFactory factory= 
				new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		//允许异步发送
		factory.setUseAsyncSend(true);
		return factory;
	}
	
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory factory= new CachingConnectionFactory(this.mqFactory());
		//缓存session
		factory.setSessionCacheSize(20);
		return factory;
	}
		//发送消息用的
	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate= new JmsTemplate();
		jmsTemplate.setConnectionFactory(this.connectionFactory());
		//开启服务质量控制    持久化 消息的生存时间，优先级  
		//开启持久化 
		jmsTemplate.setExplicitQosEnabled(true);
		jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
		//设置客户端签收
		jmsTemplate.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
		return jmsTemplate;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}






















