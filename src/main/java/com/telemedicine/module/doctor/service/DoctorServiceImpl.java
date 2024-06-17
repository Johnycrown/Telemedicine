package com.telemedicine.module.doctor.service;

import com.telemedicine.module.doctor.domain.Doctor;
import com.telemedicine.module.doctor.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements  DoctorService{
    private final DoctorRepository doctorRepository;
    @Override
    public Doctor getSingleDoctor(Long userId) throws IllegalAccessException {
        if(userId==null){
            throw new IllegalAccessException("userId is required");
        }
        Doctor doctor = doctorRepository.findByUserId(userId).orElseThrow(()->new IllegalArgumentException("doctor with the user Id "+userId+ " not found"));
        return doctor;
    }

    @Override
    public List<Doctor> fetchAllDoctor(Pageable pageable) {
        return doctorRepository.findAll(pageable).stream().toList();
    }

    @Override
    public String deleteDoctor() {
        return null;
    }
}
