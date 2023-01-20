package com.jojuskills;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcSpringbootApplication.class, args);
		System.out.println("JDBC-Spring boot app");
	}

}
