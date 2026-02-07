package com.learning.RestAPIs.controller;

import com.learning.RestAPIs.dto.StudentDto;
import com.learning.RestAPIs.entity.Student;
import com.learning.RestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //RestController helps to return JSON
@RequiredArgsConstructor

public class StudentController {

    private final StudentService studentService;


    @GetMapping("/students")
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }
}
