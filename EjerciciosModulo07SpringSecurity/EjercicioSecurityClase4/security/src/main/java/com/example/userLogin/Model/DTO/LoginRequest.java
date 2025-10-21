package com.example.userLogin.Model.DTO;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    
    @NotBlank(message = "El UserName no puede estar vacio")
    @Length(min = 5, message = "El UserName debe tener entre 4 y 20 caracteres")
    private String userName;

    @NotBlank(message = "La clave es obligatoria")
    @Length(min = 6, message = "la clave debe tener al menos 6 caracteres")
    private String password;

}