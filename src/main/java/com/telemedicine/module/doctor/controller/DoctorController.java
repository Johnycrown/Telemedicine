package com.telemedicine.module.doctor.controller;

import com.telemedicine.module.doctor.domain.Doctor;
import com.telemedicine.module.doctor.service.DoctorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
@Slf4j
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/{id}")
    public ResponseEntity<?> fetchDoctor(@PathVariable Long id){

        try {
            Doctor doctor = doctorService.getSingleDoctor(id);
            return ResponseEntity.ok().body(doctor);
        }
        catch (Exception e){
            log.info("exception caught while fetching a doctor from database {} ", e.getMessage());
        }
        return  ResponseEntity.notFound().build();
    }
    @GetMapping()
    public ResponseEntity<?> fetchDoctor(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,@RequestParam(required = false, defaultValue = "20") Integer pageSize  ){
        try {
            List<Doctor> doctor = doctorService.fetchAllDoctor(pageNumber,pageSize);
            return ResponseEntity.ok().body(doctor);
        }
        catch (Exception e){
            log.info("exception caught while fetching list of doctor from database {} ", e.getMessage());
        }
        return  ResponseEntity.notFound().build();
    }
    @GetMapping("/specialization")
    public ResponseEntity<?> fetchDoctorByspecialization( @RequestParam String specialization, @RequestParam(required = false) int pageNumber,@RequestParam(required = false) int pageSize  ){
        try {
            List<Doctor> doctor = doctorService.fetchAllDoctorBySpecialization(specialization,pageNumber,pageSize);
            return ResponseEntity.ok().body(doctor);
        }
        catch (Exception e){
            log.info("exception caught while fetching list of doctor by specialization from database {} ", e.getMessage());
        }
        return  ResponseEntity.notFound().build();
    }

}
