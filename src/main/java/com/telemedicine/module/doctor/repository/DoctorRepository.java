package com.telemedicine.module.doctor.repository;

import com.telemedicine.module.doctor.domain.Doctor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByUserId(Long userId);
    List<Doctor>    findBySpecialization(String specialization, Pageable pageable);
}
