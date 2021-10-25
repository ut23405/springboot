package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping("/test1")
    public String input1() {
        return "test1/index";
    }

	@PostMapping("/")
	public String output1(
		@RequestParam String text1,
		Model model) {
		model.addAttribute("moji1", text1);
		model.addAttribute("moji2", "こんにちは");
		return "test1/testform";
	}
}