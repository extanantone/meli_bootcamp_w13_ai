package com.bootcamp.demoHibernate.dto;

import lombok.Data;

@Data
public class StudentRequestDTO {
    private String dni;
    private String name;
    private String lastName;
    private int firstExam;
    private int secondExam;
    private int finalExam;
}
