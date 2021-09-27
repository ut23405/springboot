package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MainController {
	@Scheduled(cron = "${schedule.cron1}")
	public void output1() {
		System.out.println("こんにちは");
	}
}