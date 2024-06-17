package com.telemedicine.module.doctor.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialization;
    private Long userId;
    @ElementCollection
    private Map<String, String> availability; // Example: {"MONDAY": "09:00-17:00", "WEDNESDAY": "09:00-17:00"}

}
