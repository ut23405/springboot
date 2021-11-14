package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = "testS")
public class MainController {

	@ModelAttribute(value = "testS")
	public Syain createSyain() {
		return new Syain("suzuki");
	}

	@GetMapping("/test1")
	public String input1(@ModelAttribute("testS") Syain syain,
			Model model) {
		model.addAttribute(syain);
		return "test1/index";
	}

	@PostMapping("/testform")
	public String output1(@RequestParam String text1, Model model, 
			@ModelAttribute("testS") Syain syain) {
		model.addAttribute(syain);
		model.addAttribute("moji1", text1);
		return "test1/testform";
	}
}