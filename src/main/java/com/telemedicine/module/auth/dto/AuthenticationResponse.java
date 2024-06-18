package com.telemedicine.module.auth.dto;

import com.telemedicine.module.usermanagement.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String accessToken;
    private String refreshToken;
    private boolean mfaEnabled;
    private String secretImageUri;
    private Role role;
    private Long userId;
    private String firstname;
    private String lastname;
    private String email;

}
