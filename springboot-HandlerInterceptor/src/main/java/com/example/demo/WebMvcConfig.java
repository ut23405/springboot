package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Bean
	public TestInterceptor testInterceptor() {
		return new TestInterceptor();
	}

	public void addInterceptors(InterceptorRegistry registry) {
		registry
			.addInterceptor(testInterceptor())
			.addPathPatterns("/test1");
			//.addPathPatterns("/test2");
	}
}
