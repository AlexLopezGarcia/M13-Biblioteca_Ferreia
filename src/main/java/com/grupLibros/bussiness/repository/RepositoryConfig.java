package com.grupLibros.bussiness.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.grupLibros.bussiness.repository")
public class RepositoryConfig {
}