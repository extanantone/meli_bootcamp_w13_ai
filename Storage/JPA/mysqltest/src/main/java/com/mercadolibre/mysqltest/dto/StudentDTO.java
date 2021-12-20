package com.mercadolibre.mysqltest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.Kernel;

@Getter
@Setter
@AllArgsConstructor
public class StudentDTO {
    private int dni;
    private String firstName;
    private String lastName;
    private double firstExam;
    private double secondExam;
    private double intExam;
}
