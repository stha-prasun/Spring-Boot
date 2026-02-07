package com.learning.RestAPIs.service.impl;

import com.learning.RestAPIs.dto.StudentDto;
import com.learning.RestAPIs.entity.Student;
import com.learning.RestAPIs.repository.StudentRepository;
import com.learning.RestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(student -> new StudentDto(
                        student.getId(),
                        student.getName(),
                        student.getEmail()
                ))
                .toList();
    }
}
