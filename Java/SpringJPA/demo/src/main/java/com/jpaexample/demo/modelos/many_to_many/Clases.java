package com.jpaexample.demo.modelos.many_to_many;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Clases {

    @Id
    @GeneratedValue
    private Long id;


    @ManyToMany(mappedBy = "clases")
    @Column(nullable = false)
    private Set<Alumno> alumnos;

    /*
     En este caso si no se pone el many to meny en esta tabla que no defien la relacion, no se tendra bidireccionalidad,
     pero la relacion se crea igual en la base de datos,
     Ponerlo o no simplemente cambia la unidireccionalidad o la bidireccionaldiad
     pero la relacion se crea
     */


}
