package com.hardware.service;

import com.hardware.dto.LoginRequest;
import com.hardware.dto.RegisterRequest;
import com.hardware.vo.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);

    void register(RegisterRequest request);
}
