package com.walidzaaneun.tpiibdccspringdatahospital.services;

import com.walidzaaneun.tpiibdccspringdatahospital.entities.Consultation;
import com.walidzaaneun.tpiibdccspringdatahospital.entities.Medecin;
import com.walidzaaneun.tpiibdccspringdatahospital.entities.Patient;
import com.walidzaaneun.tpiibdccspringdatahospital.entities.RendezVous;
import com.walidzaaneun.tpiibdccspringdatahospital.repositories.ConsultationRepository;
import com.walidzaaneun.tpiibdccspringdatahospital.repositories.MedecinRepository;
import com.walidzaaneun.tpiibdccspringdatahospital.repositories.PatientRepository;
import com.walidzaaneun.tpiibdccspringdatahospital.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Patient findPatientByNom(String nom) {
        return patientRepository.findByNom(nom);
    }

    @Override
    public Medecin findMedecinByNom(String nom) {
        return medecinRepository.findByNom(nom);
    }

    @Override
    public RendezVous findRdvById(Long id) {
        return rendezVousRepository.findById(id).get();
    }
}
