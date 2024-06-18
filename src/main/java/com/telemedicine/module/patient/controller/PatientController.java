package com.telemedicine.module.patient.controller;

import com.telemedicine.module.doctor.domain.Doctor;
import com.telemedicine.module.patient.domain.Patient;
import com.telemedicine.module.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<?> fetch(@PathVariable Long id){

        try {
            Patient patient = patientService.getSinglePatient(id);
            return ResponseEntity.ok().body(patient);
        }
        catch (Exception e){
            log.info("exception caught while fetching a patient from database {} ", e.getMessage());
        }
        return  ResponseEntity.notFound().build();
    }
    @GetMapping()
    public ResponseEntity<?> fetchPatient(@RequestParam(required = false, defaultValue = "0") Integer pageNumber, @RequestParam(required = false, defaultValue = "20") Integer pageSize  ){
        try {
            List<Patient> patient = patientService.fetchAllPatient(pageNumber,pageSize);
            return ResponseEntity.ok().body(patient);
        }
        catch (Exception e){
            log.info("exception caught while fetching list of patient from database {} ", e.getMessage());
        }
        return  ResponseEntity.notFound().build();
    }

}
