package com.learning.RestAPIs.controller;

import com.learning.RestAPIs.dto.StudentDto;
import com.learning.RestAPIs.entity.Student;
import com.learning.RestAPIs.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //RestController helps to return JSON

public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student")
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }
}
