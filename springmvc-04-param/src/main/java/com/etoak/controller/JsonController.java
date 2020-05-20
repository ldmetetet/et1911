package com.etoak.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.etoak.bean.Student;
import com.etoak.bean.User;
import com.etoak.vo.ResultVo;

@RestController//controller + @ResponseBody-》 会应用到所有的方法上 
@RequestMapping("/json")
public class JsonController {
	
	@PostMapping(value = "/JsonToMap",produces = {"application/json;charset=UTF-8"})
	public Object mapToJson(@RequestBody Map<String,Object> jsonmap) {
		System.out.println(jsonmap);
		//返回json
		return "{\"str\":\"success\"}";
	}
	
	@PostMapping("/JsonToList")
	
	public Map<String,Object> jsonList(@RequestBody List<User> userList){
		userList.forEach(x -> System.out.println(x));
		Map<String,Object> resultMap= new HashMap<>();
		resultMap.put("code",200);
		resultMap.put("str","success");
		return resultMap;
	}

	@PostMapping("/JsonToBean")
	public ResultVo jsonToBean(@RequestBody Student student) {
		//打印
		System.out.println(student);
		return new  ResultVo(200,"success");//str==success
	}
}









