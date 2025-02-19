package com.ferreria.biblioteca.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    //COMO ACCEDER A LA DOCUMENTACIÓN DE LA API:
    //http://localhost:9090/swagger-ui.html
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-api")
                .packagesToScan("com.ferreria.biblioteca.presentation.controllers")
                .build();
    }

}