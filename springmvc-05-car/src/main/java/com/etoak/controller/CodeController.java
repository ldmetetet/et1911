package com.etoak.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etoak.common.VerifyCode;

@Controller
public class CodeController {
    
    @GetMapping("/code")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //创建VerifyCode对象 获取表达式的计算结果保存到session中
    	VerifyCode verifyCode = new VerifyCode();
    	//往外写的图片
        BufferedImage image = verifyCode.createImage();
        
        // 把图片上表达式的计算结果保存到session中
        //HttpSession session = request.getSession();
       request.getSession().setAttribute("code", verifyCode.getResult()+"");
        
        // 向前端写图片
        response.setHeader("Pragma", "no-cache");
        //禁止图像缓存
        response.setHeader("Cache-Control", "no-cache");
        //时间
        response.setDateHeader("Expires", 0);
        //application返回json的一个  这有一个
        response.setContentType("image/jpeg");
        //                    格式              输出流
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }
    
}














