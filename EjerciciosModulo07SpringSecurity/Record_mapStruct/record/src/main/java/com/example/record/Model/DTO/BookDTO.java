package com.example.record.Model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BookDTO(
        @NotBlank(message = "Es un campo obligatorio") 
        @Size(min = 5, message = "El titulo debe tener como minimo 5 letras") 
        String name,

        @NotBlank(message = "Es un campo obligatorio") 
        String author,

        String descripcion) {

    public BookDTO {
        if (name.length() < 5) {
            throw new RuntimeException("El titulo es invalido");
        }
    }

    public String reference(int type) {

        return switch (type) {
            case 1 -> String.format("%s, %s", author, name);
            case 2 -> String.format("%s, %s", name, author);
            default -> "Error en tipo";
        };
    }
}