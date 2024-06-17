package com.telemedicine.module.auth.dto;

import com.telemedicine.module.usermanagement.domain.Role;
import lombok.Data;

import java.util.Map;

@Data
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
    private boolean mfaEnabled;
    private String specialization;
  //  @ElementCollection
    private Map<String, String> availability; // Example: {"MONDAY": "09:00-17:00", "WEDNESDAY": "09:00-17:00"}

}
