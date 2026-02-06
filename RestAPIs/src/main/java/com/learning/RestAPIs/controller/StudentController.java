package com.learning.RestAPIs.controller;

import com.learning.RestAPIs.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //RestController helps to return JSON

public class StudentController {

    @GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto(4L, "Prasun", "stha.prasun8@gmail.com");
    }
}
