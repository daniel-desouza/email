package com.example.emaildemo;

import java.io.IOException;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.emaildemo.service.FreemarkerEmailService;
import com.example.emaildemo.service.ThymeleafEmailService;
import com.example.emaildemo.service.VelocityEmailService;

import freemarker.template.TemplateException;

@SpringBootTest
class EmaildemoApplicationTests {

	@Autowired
    private ThymeleafEmailService thymeleafEmailService;
	
	@Autowired
    private VelocityEmailService velocityEmailService;

	@Autowired
    private FreemarkerEmailService freemarkerEmailService;

    @Test
    public void testThymeleaf() {
        thymeleafEmailService.sendMail("Thymeleaf Release Email", "thymeleaf@thymeleaf.thymeleaf", "daniel@daniel.daniel");
    }
    
    @Test
    public void testVelocity() {
    	velocityEmailService.sendEmail("Velocity Release Email", "velocity@velocity.velocity", "daniel@daniel.daniel");    	
    }
    
    @Test
    public void testFreemarker() throws MessagingException, IOException, TemplateException {
    	freemarkerEmailService.sendSimpleMessage();;    	
    }

}

