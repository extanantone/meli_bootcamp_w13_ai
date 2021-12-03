package com.student.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentRequestDto {
    private String dni;
    private String name;
    private String lastName;
    private Double firstExam;
    private Double secondExam;
    private Double integrativeWork;
}
