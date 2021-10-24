package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TestControllerAdvice {

	@ExceptionHandler(TestException.class)
	public String testExceptionHandle(TestException e, Model model) {
		model.addAttribute("message1",e);
		return "test1/index";
	}
}