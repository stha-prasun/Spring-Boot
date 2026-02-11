package com.Prasun.HospitalManagement;

import com.Prasun.HospitalManagement.Entity.Patient;
import com.Prasun.HospitalManagement.Repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientsTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void TestPatientRepo(){
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }
}
