package com.etoak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etoak.bean.User;
import com.etoak.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping("/toAge")
	public String toReg() {
		System.out.println("qqqqqq");
		return "reg";//src/main/te../reg.html
	}
	
	@PostMapping("/toadd")
	public String add(User user) {
		userService.addUser(user);
		
		return "reg";
	}
}
