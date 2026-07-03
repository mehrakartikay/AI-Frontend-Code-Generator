package com.project.lovable_clone.Service;

import com.project.lovable_clone.DTO.auth.AuthResponse;
import com.project.lovable_clone.DTO.auth.LoginRequest;
import com.project.lovable_clone.DTO.auth.SignupRequest;

public interface AuthService {
    
    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
