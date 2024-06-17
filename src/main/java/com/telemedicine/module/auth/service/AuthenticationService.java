package com.telemedicine.module.auth.service;

import com.telemedicine.module.auth.dto.AuthenticationResponse;
import com.telemedicine.module.auth.dto.LoginRequest;
import com.telemedicine.module.auth.dto.RegisterRequest;
import com.telemedicine.module.auth.dto.VerifyLoginRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthenticationService {

    AuthenticationResponse registerUser(RegisterRequest request) throws Exception;
     AuthenticationResponse authenticate(LoginRequest request);
     void refreshToken(HttpServletRequest request, HttpServletResponse response
    ) throws IOException;
    AuthenticationResponse verifyCode(VerifyLoginRequest verificationRequest);
}
