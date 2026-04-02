package com.hardware.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private Long id;

    private String identity;

    private String username;

    private String password;

    private LocalDateTime lastLoginTime;
}
