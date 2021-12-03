package com.example.studenth2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentQualificationsDTO extends StudentDTO {
    private Double firstExamQualification;
    private Double secondExamQualification;
    private Double practicalClassWork;
}
