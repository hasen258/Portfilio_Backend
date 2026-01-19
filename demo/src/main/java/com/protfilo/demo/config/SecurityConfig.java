package com.protfilo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // Disable CSRF (Postman / Angular)
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        // PUBLIC endpoints
                        .requestMatchers("/api/project/*","/api/projects","/api/auth/login").permitAll()

                        // Everything else requires authentication
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
