package com.etoak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etoak.bean.Student;

/**
 * 测试javabean  数组 list  map  
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/javaBean")
public class ContextController {
	//get请求  @RequestMapping  method方法 
	//还可以用这个
	@GetMapping("/beans")
	public String bean(Student student,Model model) {
		System.out.println(student);
		model.addAttribute("result2", "使用model传值");
		return "forward:/simple/simple?id=321";
	}	
		
}
