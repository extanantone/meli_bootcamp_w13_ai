package com.example.easynotes.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Subject {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @JoinColumn(name = "student_id_lado_muchos")
    Student student;

}
