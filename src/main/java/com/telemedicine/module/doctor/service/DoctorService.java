package com.telemedicine.module.doctor.service;

import com.telemedicine.module.doctor.domain.Doctor;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    Doctor getSingleDoctor(Long userId) throws IllegalAccessException;
    List<Doctor> fetchAllDoctor(int pageNumber, int pageSize);
    List<Doctor> fetchAllDoctorBySpecialization(String specialization, int pageNumber, int pageSize);
    String deleteDoctor();

}
