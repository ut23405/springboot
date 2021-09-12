package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping("/test1")
    public String input1() {
        return "test1/index";
    }

	@GetMapping("/testform")
	public String output1(
		@RequestParam(name = "text1") String str1,
		Model model) {
		model.addAttribute("moji1", str1);
		return "test1/testform";
	}
}