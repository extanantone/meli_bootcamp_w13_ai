package com.jpaexample.demo.modelos;

import lombok.Data;

import javax.persistence.*;

/**
 * relaciones uno a uno entre dos tablas, enfoque unidireccional o bidireccional
 *
 * En enfoque unidireccional el id solo queda en la tabla principal desde la cual se van a ahcer todas las consultas
 * en este caso, desde una persona siempre vamos a obtener las direcciones y no desde las direcciones conocer las personas
 *
 * si se deseara que desde la direccion se conociera tambien la persona, se reuqiere poner un id de persona en la tabla tambien
 * en este caso como es uno a uno, quedan ligadas las tablas directamente
 *
 * @JoinColumn define quien es la tabla principal que define la relacion en caso de onetoone en perosna y direccion
 * , persona es el dueno de la relacion
 *
 * se usa la anotacion @OnetoOne(mappedBy = "Persona") desde la clase que hereda la relacion
 * la clase que no es la dueña tendra la notacion mappedBy
 * aunque no se generan los ids de la relacion redundante el jpa puede hacer la consulta desde las dos tablas
 */

@Data
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_direccion", referencedColumnName = "id")
    private Direccion direccion;

}
