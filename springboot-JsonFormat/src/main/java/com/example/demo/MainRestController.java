package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

	@PostMapping("/")
	public SyainForm disp(@RequestBody SyainForm syainForm) {
		System.out.println(syainForm.getLocalDate()); // 2022-02-05
		System.out.println(syainForm.getLocaltime()); // 23:47:22
		System.out.println(syainForm.getLocalDateTime());// 2021-10-06T23:47:22.171
		System.out.println(syainForm.getDate());// Wed Oct 06 09:00:00 JST 2021

		return syainForm;
	}
}