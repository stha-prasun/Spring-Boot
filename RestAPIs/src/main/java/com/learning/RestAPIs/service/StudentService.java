package com.learning.RestAPIs.service;

import com.learning.RestAPIs.dto.StudentDto;
import com.learning.RestAPIs.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
}
