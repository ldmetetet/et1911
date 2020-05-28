package com.etoak.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.etoak.bean.User;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//先获取session
				HttpSession session = request.getSession();
				//拿取user对象 
				User user = (User)session.getAttribute("user");
				//再看看是不是存在
				if(ObjectUtils.isEmpty(user)) {
					String path = request.getContextPath();
					response.sendRedirect(path + "/user/toLogin");
					return false;
			}
		return true;
	}
	
	/*
	 * public boolean perHandle(HttpServletRequest request,HttpServletResponse
	 * response, Object handler) throws IOException { HttpSession session =
	 * request.getSession(); User user = (User)session.getAttribute("user");
	 * if(ObjectUtils.isEmpty(user)) { String contextPath =
	 * request.getContextPath(); response.sendRedirect(contextPath
	 * +"/user/toLogin"); return false; } return true; }
	 */
	
	
}
