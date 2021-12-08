package com.bootcamp.SpringJPA.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "Estudiante")
public class Student {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private String dni;

    @Column(name = "Nombre", nullable = false)
    private String name;

    @Column(name = "Apellido", nullable = false)
    private String lastname;

    //calificaciones
    @OneToMany(mappedBy = "student")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Calification> califications;

}
