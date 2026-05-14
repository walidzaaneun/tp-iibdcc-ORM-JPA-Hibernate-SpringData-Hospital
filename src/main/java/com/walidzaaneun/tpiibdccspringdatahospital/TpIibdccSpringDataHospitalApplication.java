package com.walidzaaneun.tpiibdccspringdatahospital;

import com.walidzaaneun.tpiibdccspringdatahospital.entities.Consultation;
import com.walidzaaneun.tpiibdccspringdatahospital.entities.Medecin;
import com.walidzaaneun.tpiibdccspringdatahospital.entities.Patient;
import com.walidzaaneun.tpiibdccspringdatahospital.entities.RendezVous;
import com.walidzaaneun.tpiibdccspringdatahospital.enums.Specialite;
import com.walidzaaneun.tpiibdccspringdatahospital.enums.StatusRDV;
import com.walidzaaneun.tpiibdccspringdatahospital.repositories.ConsultationRepository;
import com.walidzaaneun.tpiibdccspringdatahospital.repositories.MedecinRepository;
import com.walidzaaneun.tpiibdccspringdatahospital.repositories.PatientRepository;
import com.walidzaaneun.tpiibdccspringdatahospital.repositories.RendezVousRepository;
import com.walidzaaneun.tpiibdccspringdatahospital.services.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class TpIibdccSpringDataHospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpIibdccSpringDataHospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService){
        return args -> {
            Patient p1 = Patient.builder()
                    .nom("Rachid")
                    .dateDeNaissance(LocalDate.of(2001,1,1))
                    .malade(true)
                    .build();
            Patient p2 = Patient.builder()
                    .nom("Souad")
                    .dateDeNaissance(LocalDate.of(1980,2,3))
                    .malade(false)
                    .build();
            Patient p3 = Patient.builder()
                    .nom("Ahmed")
                    .dateDeNaissance(LocalDate.of(1992,3,13))
                    .malade(true)
                    .build();

            hospitalService.savePatient(p1);
            hospitalService.savePatient(p2);
            hospitalService.savePatient(p3);

            Medecin m1 = Medecin.builder()
                    .nom("Aymane")
                    .specialite(Specialite.DERMATOLOGUE)
                    .email("Aymane@gmail.com")
                    .build();
            Medecin m2 = Medecin.builder()
                    .nom("Meriem")
                    .specialite(Specialite.PSYCHOLOGUE)
                    .email("Meriem@gmail.com")
                    .build();
            Medecin m3 = Medecin.builder()
                    .nom("Naoual")
                    .specialite(Specialite.CARDIOLOGUE)
                    .email("Naoual@gmail.com")
                    .build();

            hospitalService.saveMedecin(m1);
            hospitalService.saveMedecin(m2);
            hospitalService.saveMedecin(m3);

            Patient patient = hospitalService.findPatientByNom("Ahmed");
            Medecin medecin = hospitalService.findMedecinByNom("Meriem");

            RendezVous rdv = RendezVous.builder()
                    .statusRDV(StatusRDV.EN_ATTENTE)
                    .dateTime(LocalDateTime.now().plusDays(10L))
                    .medecin(medecin)
                    .patient(patient)
                    .build();

            hospitalService.saveRendezVous(rdv);

            RendezVous rendezVous = hospitalService.findRdvById(1L);

            Consultation consultation = Consultation.builder()
                    .dateConsultation(rendezVous.getDateTime().plusMinutes(15))
                    .rapport("rapport de la consultaion : ...")
                    .rendezVous(rendezVous)
                    .build();

            hospitalService.saveConsultation(consultation);
        };
    }
}
