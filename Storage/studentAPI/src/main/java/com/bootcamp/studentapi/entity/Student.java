package com.bootcamp.studentapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity(name = "Estudiante")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer idStudent;

    @Column(name = "NOMBRE", nullable = false)
    private String name;

    @Column(name = "LNAME", nullable = false)
    private String lastName;

    @Column(name = "EDAD", nullable = false)
    private Integer age;

    @Column(name = "EMAIL" , unique = true)
    private String email;

    @Column(name = "PARCIAL_1")
    private Double note1;

    @Column(name = "PARCIAL_2")
    private Double note2;

    @Column(name = "T_INTEGRADOR")
    private Double note3;

    public Student(String name, String lastName, Integer age, String email) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.note1 = null;
        this.note2 = null;
        this.note3 = null;
    }
}
