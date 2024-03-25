package com.ohashi.resilienceretryabledatabaseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ResilienceRetryableDatabaseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResilienceRetryableDatabaseServiceApplication.class, args);
	}

}
