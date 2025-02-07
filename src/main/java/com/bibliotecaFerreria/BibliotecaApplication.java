package com.bibliotecaFerreria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author alexl
 * @date 07/02/2025
 */
@SpringBootApplication(scanBasePackages = {
        "com.bibliotecaFerreria.bussiness.services",
        "com.bibliotecaFerreria.presentation",
        "com.bibliotecaFerreria.backend.config",
        "com.bibliotecaFerreria.bussiness.repository"
})

public class BibliotecaApplication {
	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}
}