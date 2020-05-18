package com.etoak.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.etoak.action.UserAction;
import com.etoak.service.UserService;
//相当于 XML的根元素的<Beans>标签  表明是一个springMvc的ioc容器
@Configuration
public class UserConfig {
	//使用@Bean注册spring bean
	@Bean("userService")             //name的属性
	public UserService  userService(){
		return new UserService();//执行一次  单例的 
	}
	
	/*
	 * @Bean public UserAction userAction() { return new UserAction(); }
	 */
	@Bean
	public UserAction userAction(@Qualifier("userService") UserService  userService) {
		UserAction userAction= new UserAction();
		//userAction.setUserService(this.userService());
		//配合@Qualifier
		userAction.setUserService(userService());
		return userAction;
	}
}
