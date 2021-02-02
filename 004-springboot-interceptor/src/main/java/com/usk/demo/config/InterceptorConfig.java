package com.usk.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.usk.demo.interceptor.AdminInterceptor;
import com.usk.demo.interceptor.UserInterceptor;

@SuppressWarnings("deprecation")
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	@Autowired
	UserInterceptor userInterceptor;
	
	@Autowired
	AdminInterceptor adminInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(userInterceptor).addPathPatterns("/users/**").excludePathPatterns("/admin/**");
		registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/**");
	}

}
