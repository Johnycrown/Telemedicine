package com.telemedicine.module.patient.service;

import com.telemedicine.module.doctor.domain.Doctor;
import com.telemedicine.module.patient.domain.Patient;

import java.util.List;

public interface PatientService {
    Patient getSinglePatient(Long userId) throws IllegalAccessException;
    List<Patient> fetchAllPatient(int pageNumber, int pageSize);

}
