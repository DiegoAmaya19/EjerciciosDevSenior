package com.example.userLogin.Model.DTO;

import org.hibernate.validator.constraints.Length;
import com.example.userLogin.Model.Shared.Role;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterRequest {
    
    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Length(min = 5, message = "El nombre de usuario debe minimo 5 caracteres")
    private String userName;
    
    @NotBlank(message = "El nombre completo es obligatorio")
    @JsonAlias("name")
    @JsonProperty("full_name")
    private String fullName;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no es valido")
    private String email;

    @Length(min = 6, message = "La contraseña debe tener minimo 8 caracteres")
    private String password;

    @NotNull(message = "El rol es obligatorio")
    private Role role;
}
