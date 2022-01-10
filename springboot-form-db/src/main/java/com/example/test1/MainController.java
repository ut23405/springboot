package com.example.test1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.test1.repository.SyainRepository;

@Controller
@RequestMapping("/test1")
public class MainController {
	private final SyainRepository syainRepository; 

	public MainController(SyainRepository syainRepository) {
		this.syainRepository = syainRepository;
	}
	
	@GetMapping()
	public String disp1(Model model) {
		System.out.println("1aa");
		model.addAttribute("syainForm", new SyainForm());
		return "test1/index";
	}

	@PostMapping("/update")
	public String disp2(SyainForm syainForm) {
		SyainDto syain = new SyainDto();
		syain.setId(syainForm.getId());
		syain.setName(syainForm.getName());
		syainRepository.insertSyain(syain);
		return "redirect:/test1/";
	}
}