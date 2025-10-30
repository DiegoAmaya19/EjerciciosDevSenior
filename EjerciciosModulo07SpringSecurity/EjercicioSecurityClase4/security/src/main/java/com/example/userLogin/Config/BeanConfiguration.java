package com.example.userLogin.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.userLogin.Mappers.UserMapper;

@Configuration
public class BeanConfiguration {

    @Bean
    UserMapper userMapper(PasswordEncoder passwordEncoder) {
        return new UserMapper(passwordEncoder);
    }    
}