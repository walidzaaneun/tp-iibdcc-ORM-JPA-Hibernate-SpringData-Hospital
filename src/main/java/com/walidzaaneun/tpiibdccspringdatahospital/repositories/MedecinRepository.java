package com.walidzaaneun.tpiibdccspringdatahospital.repositories;

import com.walidzaaneun.tpiibdccspringdatahospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
