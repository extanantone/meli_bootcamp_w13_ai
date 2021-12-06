package com.jpaexample.demo.modelos.one_to_many;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String apellido;

    @Column(nullable = false,unique = true)
    private String dni;




}
