package cat.ferreria.api.bussiness.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author alexl
 * @date 07/02/2025
 */
@Configuration
@EnableJpaRepositories(basePackages = "cat.ferreria.api.bussiness.repository")
public class RepositoryConfig {
}