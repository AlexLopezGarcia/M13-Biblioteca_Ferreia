package com.bibliotecaFerreria.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.bibliotecaFerreria.bussiness.services",
        "com.bibliotecaFerreria.presentation",
        "com.bibliotecaFerreria.backend.config",
        "com.bibliotecaFerreria.bussiness.repository"
})
@EnableJpaRepositories(basePackages = "com.bibliotecaFerreria.bussiness.repository")
@EntityScan(basePackages = "com.bibliotecaFerreria.bussiness.model")
public class BibliotecaApplication {
	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}
}