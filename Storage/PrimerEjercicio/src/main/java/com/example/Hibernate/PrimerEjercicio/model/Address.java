package com.example.Hibernate.PrimerEjercicio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "address")
    Student student;

}
