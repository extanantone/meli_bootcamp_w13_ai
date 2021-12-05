package com.bootcamp.c1p1asincimpbd.dto;

import lombok.Data;

@Data
public class StudentRequestDTO {
    private String dni;
    private String name;
    private String lastname;
    private Double firstExam;
    private Double secondExam;
    private Double integrativeWork;
}
