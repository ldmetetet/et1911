package com.etoak.startup;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.etoak.config.RootConfig;
import com.etoak.config.SpringMvcConfig;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	/**
	 * root容器
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RootConfig.class};
	}
	/**
	 * mvc容器
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {SpringMvcConfig.class};
	}
	/**
	 * 拦截地址
	 */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	 //这个过滤器是为了防止存中文乱码
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return new Filter[] {encodingFilter,
                new HiddenHttpMethodFilter()};
    }

}
