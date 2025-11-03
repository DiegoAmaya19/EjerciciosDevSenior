package com.example.userLogin.Service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.userLogin.Mappers.UserMapper;
import com.example.userLogin.Model.DTO.UserRequest;
import com.example.userLogin.Model.DTO.UserResponse;
import com.example.userLogin.Repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll().stream()
                .map(u -> UserResponse.builder()
                        .username(u.getUsername())
                        .name(u.getName())
                        .hireDate(u.getHireDate())
                        .active(u.isActive())
                        .email(u.getEmail())
                        .role(u.getRole())
                        .build())
                .toList();
    }

    @Override
    public UserResponse create(UserRequest request) {
        return mapper.toUserResponse(userRepository.save(mapper.toEntity(request)));
    }

}
