package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/test1")
public class MainController {

	@GetMapping("/login")
	public String disp1(Model model) {
		
		if (!model.containsAttribute("test1Form")) {
			model.addAttribute("test1Form", new Test1Form());
		}
		return "test1/index";
	}

	@PostMapping("/inputCheck")
	public String disp2(
			@ModelAttribute("test1Form") @Validated Test1Form test1Form, 
			BindingResult br, 
			RedirectAttributes redirectAttributes) {
		if (br.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.test1Form", br);
			redirectAttributes.addFlashAttribute("test1Form", test1Form);
			return "redirect:login";
		}
		return "test1/testform";
	}
}