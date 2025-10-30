package com.example.userLogin.Service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userLogin.Exception.BadLoginException;
import com.example.userLogin.Mappers.UserMapper;
import com.example.userLogin.Model.DTO.LoginRequest;
import com.example.userLogin.Model.DTO.RegisterRequest;
import com.example.userLogin.Model.DTO.RegisterResponse;
import com.example.userLogin.Repository.UserRepository;

@Service
public class AuthenticationServicePostgresql implements AuthenticationService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServicePostgresql(UserRepository userRepository, UserMapper userMapper,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
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
    public void login(LoginRequest credencials) {
        // if (userRepository.existsByUsernameAndPassword(
        // credencials.getUserName(),
        // passwordEncoder.encode(credencials.getPassword()))) {
        // throw new BadLoginException("Usuario o contraseña incorrecta");
        // }

        /* Usando el metodo de AutheticationManager 
           authenticate le pasamos un objeto de tipo 
           UsernamePasswordAuthenticationToken que a su 
           vez recibe como parámetro username y contraseña
           esto es para validar las credenciales de login o
           el usuario */

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        credentials.getUsername(),
                        credentials.getPassword()));

        userRepository.findById(credencials.getUserName())
                .filter(user -> passwordEncoder.matches(credencials.getPassword(), user.getPassword()))
                .orElseThrow(() -> new BadLoginException("Usuario o contraseña incorrecta"));
    }

}