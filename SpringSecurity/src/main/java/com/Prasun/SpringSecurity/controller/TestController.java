package com.Prasun.SpringSecurity.controller;

import com.Prasun.SpringSecurity.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class TestController {
    private final JwtService jwtService;

    @GetMapping("/token")
    public String token() {

        UserDetails user =
                User.builder()
                        .username("prasun")
                        .password("123")
                        .roles("USER")
                        .build();

        return jwtService.generateToken(user);
    }
}
