//package com.bibliotecaFerreria.configs;
//
//
//import com.bibliotecaFerreria.bussiness.security.JwtTokenFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
// /**
// * @author alexl
// * @date 07/02/2025
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final JwtTokenFilter jwtTokenFilter;
//
//    public SecurityConfig(JwtTokenFilter jwtTokenFilter) {
//        this.jwtTokenFilter = jwtTokenFilter;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(AbstractHttpConfigurer::disable) // Deshabilitar CSRF completamente
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/auth/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll() // Público
//                        .requestMatchers("/api/**").authenticated() // Protegido
//                )
//                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }
//}