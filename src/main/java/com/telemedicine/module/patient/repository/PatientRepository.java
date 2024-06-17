package com.telemedicine.module.patient.repository;

import com.telemedicine.module.doctor.domain.Doctor;
import com.telemedicine.module.patient.domain.Patient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByUserId(Long userId);

}
