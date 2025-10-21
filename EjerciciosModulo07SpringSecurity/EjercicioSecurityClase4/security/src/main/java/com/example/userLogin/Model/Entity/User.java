package com.example.userLogin.Model.Entity;

import java.time.LocalDate;

import com.example.userLogin.Model.Shared.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "users")
public class User {
    
    @Id
    private String username;

    private String name;

    private String email;

    private String password;

    private LocalDate hireDate;

    private boolean active;

    private Role role;
}