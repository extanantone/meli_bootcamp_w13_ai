package com.example.db1.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data

public class Student {
    @Id
    private Long id;
    private String name;
    @Column(name="PARCIAL_ONE")
    private float parcial1;
    @Column(name="PARCIAL_SECOND")
    private float parcial2;
    @Column(name="TRABAJO_INTEGRADOR")
    private float trabajoIntegrador;
}
