package com.Prasun.Project.Repository;

import com.Prasun.Project.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}