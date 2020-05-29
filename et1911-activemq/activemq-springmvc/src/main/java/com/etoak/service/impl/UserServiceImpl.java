package com.etoak.service.impl;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.etoak.bean.Email;
import com.etoak.bean.User;
import com.etoak.mapper.UserMapper;
import com.etoak.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;
	@Autowired
	JmsTemplate jmsTemplate ;
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		String userid = UUID.randomUUID().toString().replaceAll("-","");
		user.setUserId(userid);
		int result= userMapper.addUser(user);
		jmsTemplate.send("email",new MessageCreator() {
			
			@Override                 //session创建消息
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				Email email= new Email(
							user.getEmail(),
							"注册激活邮件",
							"点击右侧链接:http://localhost:8080/activemq-springmvc/user/active/"+userid);
				return session.createTextMessage(JSONObject.toJSONString(email));
			}
		});
					return result;
		
	}
}
