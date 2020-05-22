package com.etoak.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.etoak.bean.Car;
import com.etoak.service.CarService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/car")
@Slf4j
public class CarController {
	@Autowired
	CarService carService;
	//跳转页面
		@RequestMapping("/toCar")
		public String toCar() {
			return "car/add";
		}	
	//文件上传
		@RequestMapping("/addMul")
		public String add(MultipartFile file,Car car) throws IllegalStateException, IOException {//必须是{}"
			String Filename = file.getOriginalFilename();
			log.info("文件名===========》》》{}",Filename);
			log.info("car====>>>{}", car);
			file.getOriginalFilename();
			//新的文件名 
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			String newFileName = uuid+"_"+Filename;
			//直接写到d盘  
			File destFile = new File("C:/upload",newFileName);
			//之前流写进  真正上传
			file.transferTo(destFile);
			//图片上传位置  在mvc.xml配置了
			car.setPic("/pic/"+ newFileName);
			//调用服务 添加车辆
			carService.addCar(car);
			
			//没有列表 返回本页面  重定向方式跳转添加的页面路径
			return "redirect:/car/toCar";
		}
		
		
		
}














