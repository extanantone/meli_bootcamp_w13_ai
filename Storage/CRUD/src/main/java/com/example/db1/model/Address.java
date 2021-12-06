package com.example.db1.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "address")
    Student student;
}
