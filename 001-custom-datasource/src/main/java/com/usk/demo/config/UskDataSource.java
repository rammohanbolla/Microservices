package com.usk.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class UskDataSource {

	@Bean
	@Primary
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("root");
		dataSourceBuilder.url("jdbc:mysql://localhost:3306/cds");
		return dataSourceBuilder.build();
	}

}
