package com.hackathon._4.module.auth.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    MANAGER_READ("management:read"),
    MANAGER_UPDATE("management:update"),
    MANAGER_CREATE("management:create"),
    MANAGER_DELETE("management:delete"),
    DOCTOR_READ("doctor:read"),
    DOCTOR_UPDATE("doctor:update"),
    DOCTOR_CREATE("doctor:create"),
    DOCTOR_DELETE("doctor:delete"),
    PATIENT_READ("patient:read"),
    PATIENT_UPDATE("patient:update"),
    PATIENT_CREATE("patient:create"),
    PATIENT_DELETE("patient:delete"),
    APPOINTMENT_READ("appointment:read"),
    APPOINTMENT_UPDATE("appointment:update"),
    APPOINTMENT_CREATE("appointment:create"),
    APPOINTMENT_DELETE("appointment:delete"),


    ;

    @Getter
    private final String permission;
}
