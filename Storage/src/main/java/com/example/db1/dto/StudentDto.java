package com.example.db1.dto;

import com.example.db1.model.Student;
import lombok.Data;



@Data
public class StudentDto {
    private long id;
    private String name;
    private float parcial1;
    private float parcial2;
    private float trabajoIntegrador;
}
