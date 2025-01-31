package com.grupLibros.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.grupLibros.bussiness.services",
		"com.grupLibros.presentation",
		"com.grupLibros.backend.config",
		"com.grupLibros.bussiness.repository"
})
@EnableJpaRepositories(basePackages = "com.grupLibros.bussiness.repository")
@EntityScan(basePackages = "com.grupLibros.bussiness.model")
public class LibroApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibroApplication.class, args);
	}
}