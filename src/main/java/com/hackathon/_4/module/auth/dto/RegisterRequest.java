package com.hackathon._4.module.auth.dto;

import com.hackathon._4.module.usermanagement.domain.Role;

public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
    private boolean mfaEnabled;
}
