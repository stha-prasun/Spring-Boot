package com.Prasun.SpringSecurity.service;

import com.Prasun.SpringSecurity.dto.RegisterRequestDTO;
import com.Prasun.SpringSecurity.entity.User;
import com.Prasun.SpringSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public String register(RegisterRequestDTO request) {

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .role("USER")
                .build();

        repository.save(user);

        return "User Registered";
    }
}
