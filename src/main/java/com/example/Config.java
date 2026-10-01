package com.example;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.hibernate.HibernateTransactionManager;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.example")
public class Config {
	
	@Bean
	public LocalSessionFactoryBean localsessionfactory(DataSource datasource) {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(datasource);
		lsfb.setHibernateProperties(properties());
		lsfb.setPackagesToScan("com.example");
		return lsfb;
		
	}
	private Properties properties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql","true");
		return props;
		
	}
	@Bean
	public DataSource dataSource() {
		DataSource ds = new DriverManagerDataSource("jdbc:mysql://localhost:3306/orm","root","Root@1234#");
		return ds;
	}
	@Bean
	public HibernateTransactionManager hibernateTransctionManager(SessionFactory sf) {
		return new HibernateTransactionManager(sf);
		
	}
	

}
