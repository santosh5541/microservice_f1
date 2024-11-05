package com.microservices.student.microservices.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {
    private int id;
    private String name;
    private int age;
    private String gender;
    private SchoolDto school;
}
