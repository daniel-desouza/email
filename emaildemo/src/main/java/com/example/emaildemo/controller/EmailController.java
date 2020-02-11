package com.example.emaildemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emaildemo.service.VelocityEmailService;

@RestController
public class EmailController {
	
	@Autowired
	VelocityEmailService emailService;
	
	@GetMapping("/send")
	public void sendEmail(String name) {
		emailService.sendEmail("Test Email from Controller", "test@test.test", "daniel@daniel.daniel");
	}
}