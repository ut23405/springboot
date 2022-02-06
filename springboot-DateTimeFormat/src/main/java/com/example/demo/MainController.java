package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@GetMapping("/")
	public String write1() {
		return "test1/index";
	}

	@PostMapping("/check")
	@ResponseBody
	public SyainForm disp(SyainForm syainForm) {
		System.out.println(syainForm.getLocalDate()); // 2022-02-05
		System.out.println(syainForm.getLocalTime()); // 23:47:22
		System.out.println(syainForm.getLocalDateTime());// 2021-10-06T23:47:22.175
		System.out.println(syainForm.getDate());// Wed Oct 06 23:47:22 JST 2021

		return syainForm;
	}
}