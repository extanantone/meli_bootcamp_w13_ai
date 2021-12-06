package com.jpaexample.demo.modelos.one_to_many;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombreNota;

    private String contenido;


}
