package com.example.emaildemo.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class FreemarkerEmailService {

	@Autowired
    private JavaMailSender emailSender;

    @Autowired
    private Configuration freemarkerConfig;

    public void sendSimpleMessage() throws MessagingException, IOException, TemplateException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Template t = freemarkerConfig.getTemplate("freemarker-release.ftl");
        
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("replacementVariable", "replaced successfully");
        model.put("url", "https://www.google.com");

        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

        helper.setTo("test@test.test");
        helper.setText(html, true);
        helper.setSubject("Freemarker Release Email");
        helper.setFrom("from@from.from");

        emailSender.send(message);
    }
}
