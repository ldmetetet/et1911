package com.etoak.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.etoak.bean.Email;
import com.etoak.service.EmailService;

public class EmailQueueLister implements MessageListener {
	@Autowired
	EmailService emailService;
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		if(message instanceof TextMessage) {
			TextMessage msg=(TextMessage)message;
			
			try {
				String emailJson = msg.getText().toString();
				System.out.println("收到的消息" +emailJson);
				Email email = JSONObject.parseObject(emailJson, Email.class);
				emailService.sendEmail(email);
				message.acknowledge();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
