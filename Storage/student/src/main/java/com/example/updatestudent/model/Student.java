package com.example.updatestudent.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Student {

    @Id
    private Long id;
    private String dni;
    private String name;
    private String lastname;
    @Column(name = "parcial1")
    private Float test1;
    @Column(name = "parcial2")
    private Float test2;
    @Column(name = "trabajoIntegrador")
    private Float finalTest;

}
