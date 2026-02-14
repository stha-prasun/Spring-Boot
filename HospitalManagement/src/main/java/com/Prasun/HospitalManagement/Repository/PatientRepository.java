package com.Prasun.HospitalManagement.Repository;

import com.Prasun.HospitalManagement.Entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    //Query methods in JPA
    Patient findByName(String name);

    //Custom Query
    @Query("SELECT p FROM Patient p where p.email = ?1") //?1 -> first method parameter
    Patient findByEmail(@Param("email") String email);

    //Native Query
    @Query(value = "select * from patient", nativeQuery = true)
    List<Patient> findAllPatients();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
    int updateNameWithId(@Param("name") String name,
                         @Param("id") Long id);

}
