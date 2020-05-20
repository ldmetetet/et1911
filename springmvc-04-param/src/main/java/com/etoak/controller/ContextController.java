package com.etoak.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	/**
	 * 
	 * @param hobby
	 * @param modelMap
	 * @return
	 */
	@PostMapping("/array")
	public String array(String[] hobby,ModelMap modelMap) {
		for(String hoStr:hobby) {
			System.out.println("hobby->" + hoStr);
		}
		modelMap.addAttribute("result","使用Modelmap传参");
		return "paramxxxx";
	}
	/**
	 * 第五种 list 在javaBean里面
	 * @param student
	 * @param map
	 * @return
	 */
	@PostMapping("/list")
	public String list(Student student,Map<String,Object> map) {
		List<String> hobbyList = student.getHobbyList();
		if(!CollectionUtils.isEmpty(hobbyList)) {
			hobbyList.forEach(x -> System.out.println(x));
		}
		map.put("result","使用Map传参");
		return "paramxxxx";
	}
	/**
	 * 第六中 Map接受  封装在javaBean
	 * @param student
	 * @return
	 */
	//@RequestMapping("/map")   produces返回前端什么样式
	@PostMapping(value = "/map",produces = {"text/plain"})
	@ResponseBody//可以返回json xml 纯文本
	public String map(Student student) {
		System.out.println(student.getStuMap());
		return "success";
		
		
	}
	
	
	
}







































