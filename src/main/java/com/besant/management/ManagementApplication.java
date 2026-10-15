package com.besant.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Main Spring Boot annotation. Starts component scanning and auto configuration.
public class ManagementApplication {

	public static void main(String[] args) {

		// Starts the Spring Boot application and embedded Tomcat server
		SpringApplication.run(ManagementApplication.class, args);
        System.out.println("Application started");
	}

}