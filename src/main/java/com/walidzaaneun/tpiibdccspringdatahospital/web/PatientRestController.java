package com.walidzaaneun.tpiibdccspringdatahospital.web;

import com.walidzaaneun.tpiibdccspringdatahospital.entities.Patient;
import com.walidzaaneun.tpiibdccspringdatahospital.repositories.PatientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    private PatientRepository patientRepository;

    public PatientRestController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/patients")
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }
}
