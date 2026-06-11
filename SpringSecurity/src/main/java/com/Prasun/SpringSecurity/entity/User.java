package com.Prasun.SpringSecurity.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    private String role;
}
