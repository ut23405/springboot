package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * http://localhost:8765/test1/
 */
@Controller
@SessionAttributes(value = "TestSession")
public class MainController {

	@ModelAttribute(value = "TestSession")
	public Syain createSyain() {
		return new Syain("suzuki");
	}

	@GetMapping("/test1")
	public String input1(@ModelAttribute("TestSession") Syain syain,
			Model model) {
		model.addAttribute(syain);
		return "test1/index";
	}

	@PostMapping("/testform")
	public String output1(@RequestParam String textMemo, Model model, 
			@ModelAttribute("TestSession") Syain syain) {
		model.addAttribute(syain);
		model.addAttribute("memo", textMemo);
		return "test1/testform";
	}
}