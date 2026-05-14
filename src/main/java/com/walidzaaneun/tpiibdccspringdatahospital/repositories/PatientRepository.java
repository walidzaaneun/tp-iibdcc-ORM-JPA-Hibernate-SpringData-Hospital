package com.walidzaaneun.tpiibdccspringdatahospital.repositories;

import com.walidzaaneun.tpiibdccspringdatahospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String nom);
}
