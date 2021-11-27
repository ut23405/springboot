package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
 
@Controller
public class MainController {
    @GetMapping("/")
    public String disp1() {
        return "test1/login";
    }
    @PostMapping("/test1/testform")
    public String testPage() {
        return "test1/testform";
    }
}