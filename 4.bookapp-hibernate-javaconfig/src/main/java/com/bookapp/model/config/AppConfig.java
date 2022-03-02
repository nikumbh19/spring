package com.bookapp.model.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.bookapp"})
@Import(DbConfig.class)
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class AppConfig {

	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2ddl;

	@Value("${hibernate.show_sql}")
	private String showSql;

	@Value("${hibernate.format_sql}")
	private String formatSql;

	@Value("${hibernate.dialect}")
	private String dbDialect;

	@Bean
	@Autowired
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean lsb = new LocalSessionFactoryBean();
		lsb.setPackagesToScan(new String[] { "com.bookapp.web.entities"});
		lsb.setDataSource(dataSource);
		lsb.setHibernateProperties(getProperties());
		return lsb;
	}

	private Properties getProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", hbm2ddl);
		properties.setProperty("hibernate.show_sql", showSql);
		properties.setProperty("hibernate.format_sql", formatSql);
		properties.setProperty("hibernate.dialect", dbDialect);
		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}
	
	
}
