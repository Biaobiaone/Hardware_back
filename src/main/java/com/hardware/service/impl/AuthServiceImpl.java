package com.hardware.service.impl;

import com.hardware.dto.LoginRequest;
import com.hardware.dto.RegisterRequest;
import com.hardware.entity.User;
import com.hardware.exception.LoginFailedException;
import com.hardware.mapper.UserMapper;
import com.hardware.service.AuthService;
import com.hardware.util.JwtUtils;
import com.hardware.vo.LoginResponse;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public LoginResponse login(LoginRequest request) {
        if (request == null || !StringUtils.hasText(request.getUsername()) || !StringUtils.hasText(request.getPassword())) {
            throw new LoginFailedException("用户名或密码不能为空");
        }
        User user = userMapper.selectByUsername(request.getUsername());
        if (user == null || !BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            throw new LoginFailedException("用户名或密码错误");
        }
        userMapper.updateLastLoginTime(user.getId());
        LoginResponse response = new LoginResponse();
        response.setToken(jwtUtils.generateToken(user.getId(), user.getUsername(), user.getIdentity()));
        return response;
    }

    @Override
    public void register(RegisterRequest request) {
        if (request == null || !StringUtils.hasText(request.getUsername()) || !StringUtils.hasText(request.getPassword())) {
            throw new RuntimeException("用户名或密码不能为空");
        }
        User exist = userMapper.selectByUsername(request.getUsername());
        if (exist != null) {
            throw new RuntimeException("用户名已存在");
        }
        User user = new User();
        user.setIdentity("user");
        user.setUsername(request.getUsername());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(12)));
        userMapper.insertUser(user);
    }
}
