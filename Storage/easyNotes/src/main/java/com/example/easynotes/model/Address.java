package com.example.easynotes.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    Person person;


}
