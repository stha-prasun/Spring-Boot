package com.Prasun.HospitalManagement.Service;

import com.Prasun.HospitalManagement.Entity.Patient;
import com.Prasun.HospitalManagement.Repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    public final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient getPatientById(Long id){
        Patient p1 = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        return p1;
    }
}
