package com.jpaexample.demo.modelos;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // el nombre que tiene el campo en la tabla dueña de la relacion
    @OneToOne(mappedBy = "direccion")
    private Persona persona;

}
