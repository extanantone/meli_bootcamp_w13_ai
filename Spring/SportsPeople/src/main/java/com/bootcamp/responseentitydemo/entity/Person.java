package com.bootcamp.responseentitydemo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private Sport sport;
}
