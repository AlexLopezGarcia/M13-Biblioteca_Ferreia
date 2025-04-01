package cat.ferreria.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author alexl
 * @date 07/02/2025
 */
@SpringBootApplication(scanBasePackages = {
		"cat.ferreria.api.bussiness.services",
		"cat.ferreria.api.presentation.restcontrollers",
		"cat.ferreria.api.backend.config",
		"cat.ferreria.api.configs",
		"cat.ferreria.api.bussiness.repository",
		"cat.ferreria.api.bussiness.model.clazz",// Asegurar que Spring escanee las entidades
		"cat.ferreria.api.bussiness.model.dtos",// Asegurar que Spring escanee los DTOs
		"cat.ferreria.api.configs"
})
@EnableJpaRepositories("cat.ferreria.api.bussiness.repository") // Habilitar JPA Repositories
public class BibliotecaApplication {
	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}
}
