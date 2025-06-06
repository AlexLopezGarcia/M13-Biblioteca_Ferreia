package cat.ferreria.api.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * Configuración de Swagger para la API de gestión de libros.
 *
 * @author alexl
 * @date 07/02/2025
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                        .title("API de Gestión de Libros")
                        .version("1.0")
                        .description("Documentación de la API para gestionar libros en una librería"));
    }
}