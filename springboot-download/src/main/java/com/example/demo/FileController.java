package com.example.demo;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FileController {

    @GetMapping
    String index(Model model) {
        return "/index";
    }

    @PostMapping("/testDownload")
    String download(HttpServletResponse response) {
    	
        try (OutputStream os = response.getOutputStream();) {
        	
        	Path filePath = Paths.get("D:/test1/" + "test1.txt");
        	
            byte[] fb1 = Files.readAllBytes(filePath);

            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=test1.txt");
            response.setContentLength(fb1.length);
            os.write(fb1);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}