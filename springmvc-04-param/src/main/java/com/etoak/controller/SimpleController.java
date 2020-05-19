package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试简单的参数
 * @author Administrator
 *HttpServletRequest
 *使用基本数据类型  和 String
 */
@Controller
@RequestMapping("/simple")
public class SimpleController {
	//第一种接受参数 servlet api-》HttpServletRequest request
	//第一种像request域传值发
	@RequestMapping("/servlet")
	public String servlet(HttpServletRequest request) {
		//接参数
		String name = request.getParameter("name");
		//StringUtils.isEmpty(name)->包含的有name==null  。equals(name)
		if(StringUtils.isEmpty(name)) {
			name= "word";
		}//不是空
		request.setAttribute("result", "hihihi" +"--> "+ name);
		//页面
		return "paramxxxx";	
	}
	/**
	 * 第二种方式 基本数据类型 + string
	 * 二中xiangrequest域传值 ModelAndView
	 * @RequestParam 必传  当required = false  value设置参数名称  前端传参的名字
	 */
	@RequestMapping(value = "/simple",method= {RequestMethod.GET})
	public ModelAndView simple(@RequestParam(required = false,defaultValue = "1") int id,String name) {
		
		System.out.println("id param-->" + id);
		System.out.println("name param-->" + name);
		//返回视图 先创建视图
		ModelAndView model= new ModelAndView();
		//http://localhost:8080/springmvc-04-param/simple/simple?id=11&name=lll
		model.addObject("result","ModelAndView传值");
		model.setViewName("paramxxxx");
		return model;
	}
	
	
	
}


















