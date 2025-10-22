package com.devsenior.cdiaz.http.responses.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.cdiaz.http.responses.Service.DefaultService;
import com.devsenior.cdiaz.http.responses.dto.SumaResponse;

@RestController
@RequestMapping("/api/exception")
public class DefaultExceptionController {

    private final DefaultService defaultService;
    
    public DefaultExceptionController(DefaultService defaultService) {
        this.defaultService = defaultService;
    }

    @GetMapping("/suma/{num1}/{num2}")
    public SumaResponse getSuma(@PathVariable String num1, @PathVariable String num2) {
       
        return defaultService.suma(num1, num2);

    }

}
