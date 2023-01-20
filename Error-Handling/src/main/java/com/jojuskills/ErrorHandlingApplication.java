package com.jojuskills;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 

@SpringBootApplication
public class ErrorHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErrorHandlingApplication.class, args);
		
		System.out.println("Exceptional / Error Handling app");
	}

}
