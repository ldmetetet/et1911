package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 接参数
		String name = request.getParameter("name");
		//返回页面
		ModelAndView mv= new ModelAndView();
		mv.setViewName("hello");//webapp/pages/.jsp
		//传值  setAttru...
		mv.addObject("result","hello" + name);
		return mv;//返回一个视图
	}

}
