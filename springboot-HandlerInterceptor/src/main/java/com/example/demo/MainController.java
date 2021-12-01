package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@GetMapping("/test1")
	public Map<String,String> output1() {
		Map<String,String> map1 = new HashMap<>();
		map1.put("a", "赤");
		map1.put("b", "黄");
		map1.put("c", "青");
		System.out.println("return前");
		return map1;
	}
}