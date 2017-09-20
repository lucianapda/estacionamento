package br.com.estacionamento.main;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "br.com.estacionamento.model", entityManagerFactoryRef = "factoryBean")
@ComponentScan(basePackages = "br.com.estacionamento.controller")
public class ApplicationConfiguration {

	public static String getDatabaseUrl() {
		String url = System.getenv("DATABASE_URL");
		if (url == null) {
			url = "jdbc:mysql://localhost:3306/estacionamento?user=root&password=123456";
		}
		return url;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean factoryBean() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("br.com.estacionamento.model");
		return factoryBean;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driver = new DriverManagerDataSource();
		driver.setDriverClassName("com.mysql.jdbc.Driver");
		driver.setUrl(getDatabaseUrl());
		return driver;
	}
}
