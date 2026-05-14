package com.walidzaaneun.tpiibdccspringdatahospital.services;

import com.walidzaaneun.tpiibdccspringdatahospital.entities.Consultation;
import com.walidzaaneun.tpiibdccspringdatahospital.entities.Medecin;
import com.walidzaaneun.tpiibdccspringdatahospital.entities.Patient;
import com.walidzaaneun.tpiibdccspringdatahospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    Consultation saveConsultation(Consultation consultation);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Patient findPatientByNom(String nom);
    Medecin findMedecinByNom(String nom);
    RendezVous findRdvById(Long id);
}
