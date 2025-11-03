package com.example.record.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record Book(
    @NotBlank(message = "es un campo obligatorio")
    @Size(min = 5, message="El titulo debe tener como minimo 5 letras")
    String title,
    @NotBlank(message = "es un campo obligatorio")
    String author,
    String descripcion) {
    
    public Book{
        if (title.length() < 5) {
            throw new RuntimeException("El titulo es invalido");
        }
    }

    public String reference(int type){

        return switch(type){
            case 1 -> String.format("%s, %s", author, title);
            case 2 -> String.format("%s, %s", title, author);
            default -> "Error en tipo";
        };
    }
}
