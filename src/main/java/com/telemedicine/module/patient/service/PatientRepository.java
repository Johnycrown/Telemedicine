package com.telemedicine.module.patient.service;

import com.telemedicine.module.patient.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
