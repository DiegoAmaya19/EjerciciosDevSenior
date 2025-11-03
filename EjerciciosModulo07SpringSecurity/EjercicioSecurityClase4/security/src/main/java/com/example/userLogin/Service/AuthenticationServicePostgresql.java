package com.example.userLogin.Service;

import java.util.Map;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.example.userLogin.Mappers.UserMapper;
import com.example.userLogin.Model.DTO.LoginRequest;
import com.example.userLogin.Model.DTO.LoginResponse;
import com.example.userLogin.Model.DTO.RegisterRequest;
import com.example.userLogin.Model.DTO.RegisterResponse;
import com.example.userLogin.Repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationServicePostgresql implements AuthenticationService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

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
    public LoginResponse login(LoginRequest credentials) {

        /*
         * if (userRepository.existsByUsernameAndPassword(
         * credencials.getUserName(),
         * passwordEncoder.encode(credencials.getPassword()))) {
         * throw new BadLoginException("Usuario o contraseña incorrecta");
         * }
         */

        /*
         * Usando el metodo de AutheticationManager
         * authenticate le pasamos un objeto de tipo
         * UsernamePasswordAuthenticationToken que a su
         * vez recibe como parámetro username y contraseña
         * esto es para validar las credenciales de login o
         * el usuario
         */

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        credentials.getUserName(),
                        credentials.getPassword()));

        var userDetails = userDetailsService.loadUserByUsername(credentials.getUserName());
        // Generar el token JWT
        // var token = jwtService.generateToken(userDetails);

        var userInfo = userRepository.findById(credentials.getUserName());
        Map<String, Object> claims = Map.of();

        if (userInfo.isPresent()) { // Esto pregunta si el usuario tiene datos
            claims = Map.<String, Object>of(
                "name", userInfo.get().getName(),
                 "Role", userInfo.get().getRole().toString());
        }

        var token = jwtService.generateToken(claims, userDetails);

        return LoginResponse.builder()
                .jwt(token)
                .build();

    }

}