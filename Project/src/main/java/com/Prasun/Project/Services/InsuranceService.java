package com.Prasun.Project.Services;

import com.Prasun.Project.Entity.Insurance;
import com.Prasun.Project.Entity.Patient;
import com.Prasun.Project.Repository.InsuranceRepository;
import com.Prasun.Project.Repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private InsuranceRepository insuranceRepository;
    private PatientRepository patientRepository;

    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient Not Found" + patientId));

        patient.setInsurance(insurance);

        insurance.setPatient(patient); //bidirectional consistency maintenance

        return patient;
    }
}
