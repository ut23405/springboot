package com.example.demo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

    @GetMapping
    String index(Model model) {
        model.addAttribute("fileForm", new FileForm());
        return "/index";
    }

    @PostMapping("/upload")
    String upload(FileForm fileForm) {
    	
        MultipartFile mfile = fileForm.getMultipartFile();
        String fileName = mfile.getOriginalFilename();
        Path filePath = Paths.get("D:/test1/" + fileName);
        
        try {
        	Files.copy(mfile.getInputStream(), filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}