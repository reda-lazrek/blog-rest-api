package com.rean.blogrest.service;

import com.rean.blogrest.dto.AuthResponse;
import com.rean.blogrest.dto.LoginRequest;
import com.rean.blogrest.dto.RegisterRequest;

public interface AuthentificationService {
    AuthResponse register(RegisterRequest registerRequest);
    AuthResponse login(LoginRequest loginRequest);
}
