package com.telemedicine.module.patient.service;

import com.telemedicine.module.doctor.domain.Doctor;
import com.telemedicine.module.patient.domain.Patient;
import com.telemedicine.module.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    @Override
    public Patient getSinglePatient(Long userId) throws IllegalAccessException {
        if (userId == null) {
            throw new IllegalAccessException("userId is required");
        }
        return patientRepository.findByUserId(userId).orElseThrow(() -> new IllegalArgumentException("doctor with the user Id " + userId + " not found"));
    }

    @Override
    public List<Patient> fetchAllPatient(int pageNumber, int pageSize) {
        if (pageNumber > 1) {
            pageNumber -= 1;
        }
        if (pageSize < 1) {
            pageSize = 10;
        }
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return patientRepository.findAll(pageable).stream().collect(Collectors.toList());
    }
}
