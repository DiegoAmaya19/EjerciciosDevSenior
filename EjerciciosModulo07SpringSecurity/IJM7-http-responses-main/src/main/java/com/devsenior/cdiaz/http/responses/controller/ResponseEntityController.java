package com.devsenior.cdiaz.http.responses.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devsenior.cdiaz.http.responses.dto.SumaResponse;

@RestController
@RequestMapping("/api/response-entity")
public class ResponseEntityController {

    @GetMapping("/string-list")
    public ResponseEntity<List<String>> getListOfString() {
        // return ResponseEntity.ok().body(List.of("Hola", "Mundo", "Cesar"));
        return ResponseEntity.created(URI.create("/list/1")).body(List.of("Hola", "Mundo", "Cesar"));
        // return ResponseEntity.noContent().build();
    }

    @GetMapping("/suma/{num1}/{num2}")
    public ResponseEntity<SumaResponse> getSuma(@PathVariable String num1, @PathVariable String num2) {
        if (num1.isBlank()) {
            return ResponseEntity.badRequest()
                    .body(SumaResponse.builder()
                            .isError(true)
                            .errorMessage("El primer numero está en blanco")
                            .build());
        }
        if (num2.isBlank()) {
            return ResponseEntity.badRequest()
                    .body(SumaResponse.builder()
                            .isError(true)
                            .errorMessage("El segundo numero está en blanco")
                            .build());
        }
        for (var l : num1.toCharArray()) {
            if (!Character.isDigit(l)) {
                return ResponseEntity.badRequest()
                        .body(SumaResponse.builder()
                                .isError(true)
                                .errorMessage("El numero 1 no es un numero válido")
                                .build());
            }
        }
        for (var l : num2.toCharArray()) {
            if (!Character.isDigit(l)) {
                return ResponseEntity.badRequest().body(SumaResponse.builder()
                        .isError(true)
                        .errorMessage("El numero 2 no es un numero válido")
                        .build());
            }
        }

        return ResponseEntity.ok().body(
                SumaResponse.builder()
                        .isError(false)
                        .value(Integer.valueOf(num1) + Integer.valueOf(num2))
                        .build());

    }

}