package com.Prasun.MyApis.Repository;

import com.Prasun.MyApis.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
