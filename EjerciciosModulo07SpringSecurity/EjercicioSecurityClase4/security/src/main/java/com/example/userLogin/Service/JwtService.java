package com.example.userLogin.Service;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generateToken(UserDetails userDetails);
    String generateToken(Map<String,Object> claims, UserDetails userDetails);
    String extractUsername(String jwt);
    boolean isTokenExpired(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    String extractName(String token);
    String extractRole(String token);
}