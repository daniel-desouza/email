package com.example.emaildemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import freemarker.template.TemplateException;

import java.io.IOException;

import javax.mail.MessagingException;

import com.example.emaildemo.service.FreemarkerEmailService;
import com.example.emaildemo.service.ThymeleafEmailService;
import com.example.emaildemo.service.VelocityEmailService;

@RestController
public class EmailController {

	@Autowired
	VelocityEmailService emailService;

	@Autowired
	FreemarkerEmailService freemarkerEmailService;

	@Autowired
	ThymeleafEmailService thymeleafEmailService;

	@GetMapping("/send")
	public void sendEmail(String name) {
		emailService.sendEmail("Test Velocity Email from Controller", "test@test.test", "daniel@daniel.daniel");
		try {
			freemarkerEmailService.sendSimpleMessage();
		} catch (MessagingException | IOException | TemplateException e) {
			e.printStackTrace();
		}
		thymeleafEmailService.sendMail("Test Thymeleaf Email from Controller", "test@test.test", "daniel@daniel.daniel");
	}
}