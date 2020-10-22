package com.example.ec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * Main Class for the Spring Boot Application

 * @author amit
 */
@SpringBootApplication
//@OpenAPIDefinition(info = @Info(title = "Explore Places API",
//								description = "API definitions of the Explore Places Microservices",
//								version = "3.0.0"))
public class ExplorePlacesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExplorePlacesApplication.class, args);
	}

}
