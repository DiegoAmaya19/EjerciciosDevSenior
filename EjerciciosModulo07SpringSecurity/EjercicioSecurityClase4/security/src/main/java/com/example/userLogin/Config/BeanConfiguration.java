package com.example.userLogin.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.userLogin.Mappers.UserMapper;

@Configuration
public class BeanConfiguration {

    @Bean
    UserMapper userMapper() {
        return new UserMapper();
    }
    
}
