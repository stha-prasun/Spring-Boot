package com.Prasun.SpringSecurity.controller;

import com.Prasun.SpringSecurity.dto.RegisterRequestDTO;
import com.Prasun.SpringSecurity.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequestDTO request) {

        return service.register(request);
    }
}
