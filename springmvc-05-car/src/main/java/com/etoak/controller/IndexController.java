package com.etoak.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.User;

@Controller

public class IndexController {
	@RequestMapping("/addU")
	public String add(String name) {
		System.out.println(name);
		return "forward:/index";
	}
	@RequestMapping("/json")
	@ResponseBody
	public String json(@RequestBody Map<String,Object> map) {
		System.out.println(map);
		return "success";
		
	}
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		request.setAttribute("user", new User(1,"requestUser",22,""));
		//request传值
		request.getSession().setAttribute("sessionUser",new User(2,"session",22,"") );
		
		List<User> userList= new ArrayList<>();
		request.setAttribute("userList",userList);
		userList.add(new User(3,"ss",23,""));
		userList.add(new User(4,"ff",11,""));
		//webapp/templ../idnex.html
		return "index";
	}
	
}
