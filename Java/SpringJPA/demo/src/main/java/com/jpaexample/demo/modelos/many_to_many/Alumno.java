package com.jpaexample.demo.modelos.many_to_many;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 *
 * JoinColumn se refeire a la talba dominante y ala clase actual, por lo cual por ejemplo
 * en este caso para la clase Alumno iria id_alumno, JoinColumn se refiere a la clase actual
 */
@Data
@Entity
public class Alumno {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Alumno papaAlumno;

    /*
    @ManyToMany
    private Set<Clases> clases;
    */

    // definiendo los nombres de los campos en la tabla itnermedia y el nombre de la tabla
    @ManyToMany
    @JoinTable(
        // nombre de la intermedia
        name = "Alumno_clasecitas",
        // como se llamara el id de esta clase en la intermedia
        joinColumns = @JoinColumn(name = "id_alumno_new"),
        // el id de la otra clase
        inverseJoinColumns = @JoinColumn(name = "id_clases_new")
    )
    private Set<Clases> clases;

}
