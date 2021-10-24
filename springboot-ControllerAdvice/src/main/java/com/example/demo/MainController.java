package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test1")
public class MainController {

    @GetMapping()
	public String index(Model model)  {
		runSample();
		return "test1/index";
	}
    
    void runSample()   {
		int i = 5;
		if (i == 5) {
			throw new TestException("独自の例外です"); 
		}
	}
}