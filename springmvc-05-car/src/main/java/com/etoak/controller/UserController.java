package com.etoak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.User;
import com.etoak.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@GetMapping("/byId")
	@ResponseBody
	public User getById(int  id) {//http://localhost:8080/springmvc-05-car/user/byId?id=1
			return userService.getById(id);
	}
}
