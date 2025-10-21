package com.example.userLogin.Model.DTO;

import java.time.LocalDate;

import com.example.userLogin.Model.Shared.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class RegisterResponse {
    
    private String username;

    private String name;

    private String email;

    private LocalDate hireDate;

    private boolean active;

    private Role role;
}
