package com.usk.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CustomDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomDatasourceApplication.class, args);
	}

}
