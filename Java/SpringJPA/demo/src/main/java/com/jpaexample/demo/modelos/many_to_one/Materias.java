package com.jpaexample.demo.modelos.many_to_one;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Materias {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // se le dice a la relación que materias será la dueña de la relación
    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    /*e  en caso unidiereciconal estudiante es quien define la relacion*/
}
