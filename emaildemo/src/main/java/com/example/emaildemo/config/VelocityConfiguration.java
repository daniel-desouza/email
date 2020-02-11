package com.example.emaildemo.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.velocity.VelocityEngineFactory;

@SuppressWarnings("deprecation")
@Configuration
public class VelocityConfiguration {
	
    @Bean
    public VelocityEngine getVelocityEngine() throws VelocityException, IOException {    	
        VelocityEngineFactory factory = new VelocityEngineFactory();
        Properties props = new Properties();
        props.put("resource.loader", "class");
        props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        
        factory.setVelocityProperties(props);
        return factory.createVelocityEngine();
    }
}