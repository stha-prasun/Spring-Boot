package com.Prasun.HospitalManagement;

import com.Prasun.HospitalManagement.Entity.Patient;
import com.Prasun.HospitalManagement.Repository.PatientRepository;
import com.Prasun.HospitalManagement.Service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientsTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void TestPatientRepo(){
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }

    @Test
    public void TestPatientGetById(){
//        Patient p = patientService.getPatientById(1L);
//
//        System.out.println(p);

        Patient p2 = patientRepository.findByName("XYZ");

        System.out.println(p2);
    }

    @Test
    public void TestPatientQuery(){

        Patient p = patientRepository.findByEmail("abc");

        System.out.println(p);
    }
}
