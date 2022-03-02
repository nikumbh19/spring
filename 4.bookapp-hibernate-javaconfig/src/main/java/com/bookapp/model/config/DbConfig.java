package com.bookapp.model.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:db.properties")
@EnableAspectJAutoProxy
public class DbConfig {
	
	@Value(value="${jdbc.url}")
	private String url;
	
	@Value(value="${jdbc.username}")
	private String username;
	
	@Value(value="${jdbc.password}")
	private String password;
	
	@Value(value="${jdbc.driverClassName}")
	private String driverClassName;
	
	
	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setUrl(url);
		dataSource.setPassword(password);
		dataSource.setUsername(username);
		dataSource.setDriverClassName(driverClassName);
//		dataSource.setConnectionProperties(getProperties());
		return dataSource;
	}
	
	public Properties getProperties() {
		Properties properties=new Properties();
		
		properties.setProperty("url",url);
		properties.setProperty("driverClassName", driverClassName);
		properties.setProperty("username", username);
		properties.setProperty("password", password);
			
		return properties;
	}
	
	
}
