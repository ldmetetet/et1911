package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.User;
import com.etoak.exception.Et1911LoginException;
import com.etoak.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	//退出
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		// 退出之后重定向到登录页面  后面配置的有这个 直接到login页面
		return "redirect:/user/toLogin";
	}
	@RequestMapping("/byId")
	public User getById(int  id) {//http://localhost:8080/springmvc-05-car/user/byId?id=1
			return userService.getById(id);
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String name,//
						@RequestParam String password,//
						@RequestParam String code,//类似数据库的
						HttpServletRequest request) {
				//session中的验证码和请求参数的验证码对比
				//首先request创建session
				HttpSession session = request.getSession();
				//从request与里面那session  就是用户传的code  
				String sessionCode=(String)session.getAttribute("code");
				if(!code.equals(sessionCode)) {
					throw new Et1911LoginException("验证码不正确");
				}
				//验证用户
				password = DigestUtils.md5Hex(password);
				//根据密码和用户名登陆 名叫user
				User user = userService.getByNameAndPaword(name, password);
				if(ObjectUtils.isEmpty(user)) {
					throw new Et1911LoginException("用户名或密码不正确");
				}
				//销毁session
				session.invalidate();
				//创建新的  就是付给之前的那个session
				session=request.getSession();
				session.setAttribute("user", user);
				return "redirect:/";//登录成功，跳转到index页面
	}
}


	



















