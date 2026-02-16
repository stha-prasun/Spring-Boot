package com.Prasun.Project.Services;

import com.Prasun.Project.Entity.Insurance;
import com.Prasun.Project.Entity.Patient;
import com.Prasun.Project.Repository.InsuranceRepository;
import com.Prasun.Project.Repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient Not Found" + patientId));

        patient.setInsurance(insurance);

        insurance.setPatient(patient); //bidirectional consistency maintenance

        return patient;
    }
}
