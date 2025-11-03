package com.example.userLogin.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.userLogin.Model.DTO.UserRequest;
import com.example.userLogin.Model.DTO.UserResponse;
import com.example.userLogin.Service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserResponse create(@RequestBody UserRequest request) {
        return userService.create(request);
    }

    @PreAuthorize("hasRole('ADMIN') or pincipal.username = #username")
    @PutMapping("/{username}")
    public UserResponse update(@PathVariable String username, @RequestBody @Valid UserRequest request) {
        // TODO: Pendiente por implementar
        return null;
    }

    @PreAuthorize("principal.username == #username")
    @PatchMapping("/{username}/baja")
    public void inactivate(@PathVariable String username) {
        // TODO: Pendiente de implementar
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{username}")
    public void delete(@PathVariable String username) {
        // TODO: Pendiente por implementar
    }

}