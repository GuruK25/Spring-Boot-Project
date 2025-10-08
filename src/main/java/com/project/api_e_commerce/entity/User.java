package com.project.api_e_commerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Long mobile;
    @CreationTimestamp
    private LocalDateTime createdTime;
    private int otp;
    private LocalDateTime otpExpiryTime;
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean status;
}
