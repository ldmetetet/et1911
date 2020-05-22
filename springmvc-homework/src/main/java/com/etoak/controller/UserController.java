package com.etoak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/user")
public class UserController {
	@RequestMapping("/addu")
	public String add() {
		System.out.println("vvvvv");
		return "index";
	}
}
