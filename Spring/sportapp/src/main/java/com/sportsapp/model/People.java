package com.sportsapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class People {
    private String name;
    private String lastName;
    private int age;
    private Sport sport;
}
