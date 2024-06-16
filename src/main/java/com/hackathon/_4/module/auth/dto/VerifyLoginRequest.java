package com.hackathon._4.module.auth.dto;

import lombok.*;

@Builder
@Data
public class VerifyLoginRequest {
    private String email;
    private String code;
}
