package com.telemedicine.module.appointment.repository;

import com.telemedicine.module.appointment.domain.Appointment;
import com.telemedicine.module.appointment.domain.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByAppointmentDateBetweenAndStatus(LocalDateTime start, LocalDateTime end, AppointmentStatus status);
    List<Appointment> findByDoctorId(Long id);

    List<Appointment> findByPatientId(Long id);


}
