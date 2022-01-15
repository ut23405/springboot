package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test1")
public class MainController {

	@GetMapping("/")
	public String disp1() {
		return "test1/index";
	}

	@PostMapping("/check")
	@ResponseBody
	public SyainForm disp2(SyainForm syainForm) {
		syainForm.setMemo("登録しました");
		syainForm.setName(syainForm.getName() + " さん");
		syainForm.setRomaji(syainForm.getRomaji() + " san");
		return syainForm;
	}
}