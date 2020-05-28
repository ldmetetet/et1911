package com.etoak.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.Dict;
import com.etoak.bean.Page;
import com.etoak.exception.ParamException;
import com.etoak.service.CarService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/car")
@Slf4j
public class CarController {
	@Autowired
	CarService carService;
	//location

	//条件查询
	@GetMapping("/getBrand")
	@ResponseBody
	public List<String> getBrand() {
		return carService.getAllBrand();
	}
	
	@GetMapping("/getSeries")
	@ResponseBody
	public List<String> getSeries(String brand) {
		return carService.getSeriesByBrand(brand);
	}
	//列表分页
	@GetMapping("/list")
	@ResponseBody//传的是json
	public Page<CarVo> list(
			@RequestParam(required = false,defaultValue = "1") int pageNum,
		    @RequestParam(required = false,defaultValue = "8") int pageSize,
		    CarVo carVo,
		    String[] priceList){
		return carService.queryList(pageNum, pageSize, carVo,priceList);
	}
	//跳转列表链接
	@RequestMapping("/tolist")
	public String toList() {
		return "car/list";
	}
	//跳转添加页面
		@RequestMapping("/toCar")
		public String toCar() {
			return "car/add";
		}	
	//文件上传
		@RequestMapping("/addMul")            // 加上 Valid  bean上的注解有效
		public String add(MultipartFile file,@Valid Car car,BindingResult bindingResult,
				HttpServletRequest request) throws IllegalStateException, IOException {//必须是{}"
			String Filename = file.getOriginalFilename();
			log.info("文件名===========》》》{}",Filename);
			log.info("car====>>>{}", car);
			//校验 获取结果  -->空就是继续添加信息  就是没有空的   
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			//判断校验的信息  Error不是空的 说明有信息  就是有空的 
			if(!CollectionUtils.isEmpty(allErrors)) {
				//集合 或者stringbuffer(不会自动扩容)拼接  存放信息
				//string 可以自动创建新的空间  
				StringBuffer errorBuff = new StringBuffer();
				//遍历Errors
				for(ObjectError error:allErrors) {
					//
					String erorrMsg = error.getDefaultMessage();
					//拼接
					errorBuff.append(erorrMsg).append(";");
				}
				//放到request域里
			/*
			 * request.setAttribute("paramError", errorBuff.toString()); return
			 * "forward:/car/toCar";
			 */
				//自定义抛出异常  让全局异常处理器处理  再有一个 直接写这个了
				throw new ParamException(errorBuff.toString());
			}
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














