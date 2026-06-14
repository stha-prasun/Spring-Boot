package com.Prasun.SpringSecurity.service;

import com.Prasun.SpringSecurity.dto.LoginRequestDTO;
import com.Prasun.SpringSecurity.dto.RegisterRequestDTO;
import com.Prasun.SpringSecurity.entity.User;
import com.Prasun.SpringSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;

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

    public String login(LoginRequestDTO request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        return "Login Successful";
    }
}
