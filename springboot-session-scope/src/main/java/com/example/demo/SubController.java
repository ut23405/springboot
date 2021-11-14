package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubController {
	@Autowired Syain syain;
	
	@PostMapping("/testform")
	public String output1(@RequestParam String text1, Model model 
			) {
		model.addAttribute("moji1", text1);
		model.addAttribute(syain);
		return "test1/testform";
	}
}