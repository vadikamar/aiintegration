package com.service.aiintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.service.aiintegration")
public class AiIntegrationApplication {
	public static void main(String[] args) {
		SpringApplication.run(AiIntegrationApplication.class, args);
	}
}
