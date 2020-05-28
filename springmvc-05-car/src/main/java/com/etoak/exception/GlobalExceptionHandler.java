package com.etoak.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import lombok.extern.slf4j.Slf4j;
/**
 * 全局异常处理器
 * @ControllerAdvice会在controller 注解的方法上加一个拦截
 * 当方法controller控制器方法有异常抛出的时候会在这个异常处理器拦截
 * @author Administrator
 *	异常处理方式一. @ExceptionHandler 
	异常处理方式二. 实现HandlerExceptionResolver接口
	异常处理方式三. @ControllerAdvice+@ExceptionHandler
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	@ExceptionHandler(Et1911LoginException.class)
	public ModelAndView handleLoginException(Et1911LoginException e) {
		String msg = e.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("error",msg);
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@ExceptionHandler(ParamException.class)
	public  ModelAndView handlePaeamException(ParamException e) {
		String message = e.getMessage();
		log.error(message,e);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("paramError", message);//key是前端页面的接受参数
		//返回一个视图 视图路径
		modelAndView.setViewName("car/add");//页面 add.html
		return modelAndView;
	}
}
