package com.caofuquan.config;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
@Configuration
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/book/addbook").setViewName("add");
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper  = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		return mapper;
	}
	//文件上传后在页面显示需加配置方法
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("file:D:/book/upload/");
		
	}
}
