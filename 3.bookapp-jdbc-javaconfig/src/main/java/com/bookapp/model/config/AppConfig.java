package com.bookapp.model.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages= {"com.bookapp"})
@Import(DbConfig.class)
public class AppConfig {
	
}
