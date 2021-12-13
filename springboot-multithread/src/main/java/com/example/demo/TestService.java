package com.example.demo;

import java.time.LocalDateTime;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Async
	public void getMulti() {
		try {
			Thread.sleep(3000); //3秒待つ
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Logger logger = LoggerFactory.getLogger(TestService.class);
		logger.info("Multi");
		System.out.println("Multi=" + LocalDateTime.now());
    }
}
