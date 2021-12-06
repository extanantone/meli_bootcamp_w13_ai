package com.jpaexample.demo.modelos.many_to_one;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Maletas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;


}
