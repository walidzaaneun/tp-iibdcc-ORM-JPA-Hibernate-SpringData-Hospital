package com.walidzaaneun.tpiibdccspringdatahospital.repositories;

import com.walidzaaneun.tpiibdccspringdatahospital.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
