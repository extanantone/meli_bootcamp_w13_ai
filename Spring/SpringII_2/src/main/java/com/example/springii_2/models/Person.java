package com.example.springii_2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String name;
    private  String lastName;
    private Integer edad;
    private Integer sportId;

}
