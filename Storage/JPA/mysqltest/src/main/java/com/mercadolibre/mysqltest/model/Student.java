package com.mercadolibre.mysqltest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;

    @Column(length = 10, nullable = false)
    int dni;

    @Column(length = 20, nullable = false)
    String firstName;

    @Column(length = 20, nullable = false)
    String lastName;

    double FirstExam;
    double SecondExam;
    double IntExam;
}
