package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test1")
public class MainController {
    @Autowired
    private SyainRepository syainRepository;
    
    @GetMapping()
    public String disp1(
    		Model model) {
    	model.addAttribute("test1Form", new Test1Form());
        return "test1/index";
    }

    @PostMapping("/testform")
	public String disp2(Test1Form test1Form) {
		Syain syain = new Syain();
		syain.setId(test1Form.getId());	
		syain.setName(test1Form.getName());
		syainRepository.insertSyain(syain);
		return "redirect:/test1/";
	}
}