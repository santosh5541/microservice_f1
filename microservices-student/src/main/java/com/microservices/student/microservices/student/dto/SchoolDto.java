package com.microservices.student.microservices.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {
    private int id;
    private String schoolName;
    private String location;
    private String principalName;
}