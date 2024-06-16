package com.hackathon._4.module.auth.dto;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;
    private String password;
}
