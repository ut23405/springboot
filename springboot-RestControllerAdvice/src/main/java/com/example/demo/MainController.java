package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@PostMapping
	public String output1(@RequestBody Color color) {		
		System.out.println(color.getColor1());
		System.out.println(color.getColor2());
		int i = 5;
		if (i == 5) {
			throw new NullPointerException(); 
		}
		return "test";
	}
}
