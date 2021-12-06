package com.example.easynotes.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    //!TODO ver docu de generator = "native"
    @GeneratedValue(strategy = GenerationType.AUTO)
    //TODO ver documentación
    //@GenericGenerator(name = "native",strategy = "native")
    private Long id;

    @Column(name= "first_name", nullable=false)
    private String firstName;

    @Column(name= "last_name", nullable=false)
    @Size(max = 55)
    private String lastName;

    private int edad;

    private String lugarNacimiento;

    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY)
    private Set<Note> authorNotes = new HashSet<>();

}
