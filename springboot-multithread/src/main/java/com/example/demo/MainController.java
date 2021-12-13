package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class MainController {
	@Autowired
	TestService test;
	
	@GetMapping("/")
	public String write1() {
		Logger logger = LoggerFactory.getLogger(MainController.class);
		logger.info("main"); 
		test.getMulti(); //メソッド呼び出し1
		test.getMulti(); //メソッド呼び出し2
		System.out.println("Main=" + LocalDateTime.now());
		return "test1";
	}
}
