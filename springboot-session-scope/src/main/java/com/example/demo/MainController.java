package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@Autowired Syain syain;

	@GetMapping("/test1")
	public String input1(Model model) {
		
		syain.setName("suzuki");
		model.addAttribute(syain);
		return "test1/index";
	}
}