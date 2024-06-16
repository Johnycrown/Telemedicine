package com.hackathon._4.module.auth.service;

import com.hackathon._4.module.auth.dto.AuthenticationResponse;
import com.hackathon._4.module.auth.dto.LoginRequest;
import com.hackathon._4.module.auth.dto.RegisterRequest;
import com.hackathon._4.module.auth.dto.VerifyLoginRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthenticationService {

    AuthenticationResponse registerUser(RegisterRequest request);
     AuthenticationResponse authenticate(LoginRequest request);
     void refreshToken(HttpServletRequest request, HttpServletResponse response
    ) throws IOException;
    AuthenticationResponse verifyCode(VerifyLoginRequest verificationRequest);
}
