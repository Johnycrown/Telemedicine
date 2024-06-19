package com.telemedicine.module.appointment.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long doctorId;
    private Long patientId;
    private LocalDateTime appointmentDate;
    private String urgency; // Example: "low", "medium", "high"
//460
    private boolean telemedicine;

   @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
}
