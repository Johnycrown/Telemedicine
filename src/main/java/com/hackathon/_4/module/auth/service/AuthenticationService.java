package com.hackathon._4.module.auth.service;

import com.hackathon._4.module.auth.dto.AuthenticationResponse;
import com.hackathon._4.module.auth.dto.RegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse registerUser(RegisterRequest request);
}
