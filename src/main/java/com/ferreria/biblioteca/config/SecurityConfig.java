package com.ferreria.biblioteca.config;

import com.ferreria.biblioteca.security.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JwtTokenFilter jwtTokenFilter;

    public SecurityConfig(JwtTokenFilter jwtTokenFilter) {
        this.jwtTokenFilter = jwtTokenFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)  // Deshabilitar CSRF si no lo necesitas
                .authorizeHttpRequests(auth -> auth
                        // Rutas públicas que no requieren autenticación (sin token)
                        .requestMatchers("/login", "/register", "/public/**").permitAll()
                        // Restringir acceso a endpoints que comienzan con /api (requieren autenticación JWT)
                        .requestMatchers(HttpMethod.GET, "/api/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/**").authenticated()
                )
                .addFilterBefore(jwtTokenFilter, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class)  // Colocar el filtro JWT antes del filtro de autenticación de usuario
                .build();
    }
}
