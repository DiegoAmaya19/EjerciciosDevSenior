package com.example.userLogin.Mappers;

import java.time.LocalDate;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.userLogin.Model.DTO.RegisterRequest;
import com.example.userLogin.Model.DTO.RegisterResponse;
import com.example.userLogin.Model.Entity.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserMapper {
    
    private final PasswordEncoder passwordEncoder;

    public User toEntity(RegisterRequest request){

        return User.builder()
            .username(request.getUserName())
            .password(passwordEncoder.encode(request.getPassword()))
            .name(request.getFullName())
            .email(request.getEmail())
            .role(request.getRole())
            .active(true)
            .hireDate(LocalDate.now())
            .build();

    }

    public RegisterResponse toResponse(User user){
        return RegisterResponse.builder()
            .username(user.getUsername())
            .name(user.getName())
            .email(user.getEmail())
            .hireDate(user.getHireDate())
            .active(user.isActive())
            .role(user.getRole())
            .build();
    }
}
