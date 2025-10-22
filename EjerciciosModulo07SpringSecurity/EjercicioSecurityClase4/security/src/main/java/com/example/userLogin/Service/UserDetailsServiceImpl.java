package com.example.userLogin.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.userLogin.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        var userInfo = userRepository.findById(username)
            .orElseThrow(() -> new UsernameNotFoundException("Este usuario no existe " + username));

        var response = User.builder()
            .username(userInfo.getUsername())
            .password(userInfo.getPassword())
            .roles("USER")
            .build();
        
        return response;
    }
    
}