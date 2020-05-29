package com.etoak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.stereotype.Controller;//
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * component scan 
 * 就是springmvc.xml
 * @author Administrator
 *import org.springframework.stereotype.Controller;//
 *要的是注解类型，不是接口类型，重新导包。
 */
@Configuration//ioc容器
@ComponentScan(
		basePackages = {"com.etoak"},//
		includeFilters = {@Filter(type=FilterType.ANNOTATION,//
		classes= {Controller.class, RestController.class,//
				ControllerAdvice.class, EnableWebMvc.class
		})},// 
		excludeFilters = {@Filter(type=FilterType.ANNOTATION,// 
		classes= {Service.class, Repository.class//
		})} //
	)

@EnableWebMvc//driven
public class SpringMvcConfig implements WebMvcConfigurer{

	//handler
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.enable();
	}
	//resources
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
			registry.addResourceHandler("/pic/**")
			.addResourceLocations("file:C:/upload/");
	}
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver= 
				new SpringResourceTemplateResolver();
		resolver.setPrefix("classpath:/templates/");
		resolver.setSuffix(".html");
		resolver.setCharacterEncoding("UTF-8");
		resolver.setTemplateMode(TemplateMode.HTML);
		resolver.setCacheable(false);
		return resolver;
	}
	@Bean
	public SpringTemplateEngine engine () {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(this.templateResolver());
		return engine;
	}
	@Bean
	public ThymeleafViewResolver resolver () {
		ThymeleafViewResolver resolver= new ThymeleafViewResolver();
		resolver.setTemplateEngine(this.engine());
		resolver.setCharacterEncoding("UTF-8");
		return resolver;
	}
	
	
	
}





















