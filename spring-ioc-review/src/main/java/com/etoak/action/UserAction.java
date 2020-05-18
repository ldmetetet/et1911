package com.etoak.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.etoak.bean.User;
import com.etoak.service.UserService;
//@Controller
public class UserAction {
	//@Autowired   有了 @Qualifier  
	private UserService userService;
	//有了@
	/*
	 * public UserService getUserService() { return userService; } public void
	 * setUserService(UserService userService) { this.userService = userService; }
	 */
	public void setUserService(UserService userService) { this.userService = userService; }
	public User getById(int  id) {
		return userService.getById(id);
	}
}
