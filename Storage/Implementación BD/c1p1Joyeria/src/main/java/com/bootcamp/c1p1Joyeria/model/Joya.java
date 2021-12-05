package com.bootcamp.c1p1Joyeria.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nroIdentificatorio;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo = true;
}
