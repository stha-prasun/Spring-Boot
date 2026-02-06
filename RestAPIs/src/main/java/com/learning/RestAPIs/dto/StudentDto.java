package com.learning.RestAPIs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //No need for Getters and Setters
@AllArgsConstructor //No need for Constructor
public class StudentDto {
    private long id;
    private String name;
    private String email;
}
