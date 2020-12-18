package com.usk.uskprofiles.profileConfig;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class TestConfig {

	private String url;
	private String username;
	private String password;
	private String driverClassName;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	/*
	 * @Profile("dev")
	 * 
	 * @Bean public DataSource getDataSource() {
	 * System.out.println("==============>>" + url); DataSourceBuilder
	 * dataSourceBuilder = DataSourceBuilder.create();
	 * dataSourceBuilder.driverClassName(driverClassName);
	 * dataSourceBuilder.url(url); dataSourceBuilder.username(username);
	 * dataSourceBuilder.password(password); return dataSourceBuilder.build(); }
	 * 
	 * @Profile("prod")
	 * 
	 * @Bean public DataSource mySqlDataSource() {
	 * System.out.println("==============>>" + url); DataSourceBuilder
	 * dataSourceBuilder = DataSourceBuilder.create(); dataSourceBuilder.url(url);
	 * dataSourceBuilder.username(username); dataSourceBuilder.password(password);
	 * return dataSourceBuilder.build(); }
	 */

}
