package com.telemedicine.module.doctor.service;

import com.telemedicine.module.doctor.domain.Doctor;
import com.telemedicine.module.doctor.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Doctor> fetchAllDoctor(int pageNumber, int pageSize) {
        if(pageNumber>1){
            pageNumber -=1;
        }
        if(pageSize<1){
            pageSize = 10;
        }
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return doctorRepository.findAll(pageable).stream().collect(Collectors.toList());
    }

    @Override
    public List<Doctor> fetchAllDoctorBySpecialization(String specialization,int pageNumber, int pageSize) {
        if(pageNumber>1){
            pageNumber -=1;
        }
        if(pageSize<1){
            pageSize = 10;
        }
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return doctorRepository.findBySpecialization(specialization,pageable);
    }

    @Override
    public String deleteDoctor() {
        return null;
    }
}
