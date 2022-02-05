package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TestControllerAdvice {
	
	@ExceptionHandler(NullPointerException.class)
	public String test(HttpServletRequest request) {
		return request.getLocalAddr();
	}
}