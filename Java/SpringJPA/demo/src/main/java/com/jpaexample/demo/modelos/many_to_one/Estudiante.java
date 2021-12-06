package com.jpaexample.demo.modelos.many_to_one;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // siempre que se maneja una colección de entidades el framework crea una tabla intermedia si no configura nada más
    // si pongo el mapped eliminara la tabla intermedia, como el estudiante tiene n materias y las materias 1 estudiante
    // se dejan el joinColumn en materias


    @OneToMany(mappedBy = "estudiante")
    private Set<Materias> estudianteMaterias = new HashSet<>();
    @OneToMany(mappedBy = "estudiante")
    private Set<Maletas> estudianteMaletas = new HashSet<>();

    /**
     * caso unidireccional, las maeltas no podrian saber desde el codigo java como encontrar su estudiante
     *
    @OneToMany
    @JoinColumn(name = "id_estudiante")
    Set<Maletas> maletas;
    */

}
