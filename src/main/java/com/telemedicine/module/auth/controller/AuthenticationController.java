package com.telemedicine.module.auth.controller;

import com.telemedicine.module.auth.dto.AuthenticationResponse;
import com.telemedicine.module.auth.dto.LoginRequest;
import com.telemedicine.module.auth.dto.RegisterRequest;
import com.telemedicine.module.auth.dto.VerifyLoginRequest;
import com.telemedicine.module.auth.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/register")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest request
    ) {try {
        var response = service.registerUser(request);
        if (request.isMfaEnabled()) {
            return ResponseEntity.ok(response);
        }
    }catch (Exception e){
        log.info("exception caught while saving user  {}", e.getMessage());
    }
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody LoginRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyCode(
            @RequestBody VerifyLoginRequest verificationRequest
    ) {
        return ResponseEntity.ok(service.verifyCode(verificationRequest));
    }

}
