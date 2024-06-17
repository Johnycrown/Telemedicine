package com.telemedicine.module.auth.dto;

import lombok.*;

@Builder
@Data
public class VerifyLoginRequest {
    private String email;
    private String code;
}
