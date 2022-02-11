package com.example.test1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@PostMapping("/test1")
	public Syain input1(@RequestBody Syain syain) {
		System.out.println("con1=" + syain.getSyainName());
		int i = 5;
		if (i == 5) {
			throw new NullPointerException(); 
		}
		System.out.println("con2");
		return syain;
	}
}