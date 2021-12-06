package com.bootcamp.StudentProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {
    private String dni;
    private String name;
    private String lastName;
    private Double firstExam;
    private Double secondExam;
    private Double integrativeWork;
}