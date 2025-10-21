package com.example.userLogin.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(c -> c.disable())
            .authorizeHttpRequests(authz -> authz
            .requestMatchers("/auth/**").permitAll()
                .anyRequest().denyAll())
            .httpBasic(b -> {});

        return http.build();
    }
}
