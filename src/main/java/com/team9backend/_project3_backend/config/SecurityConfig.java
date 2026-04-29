package com.team9backend._project3_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disabled CSRF for frontend testing, can delete after i think
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Allows all traffic without login
                );
        return http.build();
    }
}