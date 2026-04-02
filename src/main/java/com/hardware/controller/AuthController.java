package com.hardware.controller;

import com.hardware.common.Result;
import com.hardware.dto.LoginRequest;
import com.hardware.dto.RegisterRequest;
import com.hardware.service.AuthService;
import com.hardware.vo.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Result<LoginResponse> login(@RequestBody LoginRequest request) {
        return Result.success(authService.login(request));
    }

    @PostMapping("/register")
    public Result<Object> register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return Result.success();
    }
}
