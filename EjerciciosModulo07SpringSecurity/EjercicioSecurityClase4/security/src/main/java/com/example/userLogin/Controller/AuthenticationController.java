package com.example.userLogin.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.userLogin.Model.DTO.LoginRequest;
import com.example.userLogin.Model.DTO.LoginResponse;
import com.example.userLogin.Model.DTO.RegisterRequest;
import com.example.userLogin.Model.DTO.RegisterResponse;
import com.example.userLogin.Service.AuthenticationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    
    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest body) {
        return authenticationService.login(body);
    }

    @ResponseStatus(code =  HttpStatus.CREATED)
    @PostMapping("/register")
    public RegisterResponse register(@RequestBody @Valid RegisterRequest body) {

        return authenticationService.register(body);
        
    }
}
