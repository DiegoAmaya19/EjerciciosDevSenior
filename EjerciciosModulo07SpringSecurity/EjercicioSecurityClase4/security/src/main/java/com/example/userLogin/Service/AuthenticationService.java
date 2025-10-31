package com.example.userLogin.Service;

import com.example.userLogin.Model.DTO.LoginRequest;
import com.example.userLogin.Model.DTO.LoginResponse;
import com.example.userLogin.Model.DTO.RegisterRequest;
import com.example.userLogin.Model.DTO.RegisterResponse;


public interface AuthenticationService {
    RegisterResponse register(RegisterRequest userInfo);

    LoginResponse login(LoginRequest body);
}