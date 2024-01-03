package com.smartcomputers.smartproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;


@SpringBootApplication
public class SmartProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(SmartProjectApplication.class, args);
	}
}
