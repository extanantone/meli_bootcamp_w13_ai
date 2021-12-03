package com.joyeria.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Material material;

    private double peso;

    private String particularidad;

    private boolean poseePriedra;
}
