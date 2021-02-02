package com.usk.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.usk.demo.interceptor.AdminInterceptor;
import com.usk.demo.interceptor.UserInterceptor;

@Component
public class Interceptorconfig implements WebMvcConfigurer{
	
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
