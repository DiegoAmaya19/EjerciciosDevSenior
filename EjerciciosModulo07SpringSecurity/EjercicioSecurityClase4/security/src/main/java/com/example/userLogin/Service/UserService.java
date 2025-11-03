package com.example.userLogin.Service;

import java.util.List;
import com.example.userLogin.Model.DTO.UserRequest;
import com.example.userLogin.Model.DTO.UserResponse;

public interface UserService {

    List<UserResponse> getAll();
    UserResponse create(UserRequest request);
}
