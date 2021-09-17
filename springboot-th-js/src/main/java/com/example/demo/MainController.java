package com.example.demo;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	
	@GetMapping("/test1")
	public String output1(Model model) {
		Syain s1 = new Syain();
		s1.setId(1);
		s1.setName("suzuki");
		Syain s2 = new Syain();
		s2.setId(2);
		s2.setName("tanaka");
		model.addAttribute("syain", Arrays.asList(s1,s2));
		return "test1/index";
	}
}
class Syain{
	private int id;
	private String name;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
