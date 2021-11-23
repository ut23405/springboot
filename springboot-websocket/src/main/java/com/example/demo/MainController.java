package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private SimpMessagingTemplate template;

	@MessageMapping("/web1")
	public void send1(@Payload String message) {
		template.convertAndSend("/topic/client1", "send=" + message);
	}
	
	@GetMapping("/test1")
    public String input1() {
        return "test1/index";
    }
}