package com.example.userLogin.Service;

import org.springframework.stereotype.Service;
import com.example.userLogin.Mappers.UserMapper;
import com.example.userLogin.Model.DTO.LoginRequest;
import com.example.userLogin.Model.DTO.RegisterRequest;
import com.example.userLogin.Model.DTO.RegisterResponse;
import com.example.userLogin.Repository.UserRepository;

@Service
public class AuthenticationServicePostgresql implements AuthenticationService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public AuthenticationServicePostgresql(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public RegisterResponse register(RegisterRequest userInfo) {
        // Verficar el UserName no exista en la base de datos
        // Verificar que el correo no exista en la base de datos

        // Creo una entidad con los datos del Request

        var user = userMapper.toEntity(userInfo);

        // Guardo en la base de datos

        user = userRepository.save(user);

        // Convierto el objeto guardado a response

        var reponse = userMapper.toResponse(user);

        // Devuelvo el response
        return reponse;
    }

    @Override
    public void login(LoginRequest body) {
        
    }
    
}