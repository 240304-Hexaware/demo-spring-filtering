package com.revature.demospringfiltering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.revature.demospringfiltering.beans")
public class DemoSpringFilteringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringFilteringApplication.class, args);
	}

}
