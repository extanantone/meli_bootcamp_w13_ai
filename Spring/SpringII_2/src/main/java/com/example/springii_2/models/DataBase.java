package com.example.springii_2.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DataBase {

    List<Sport> sports  = new ArrayList<>();
    List<Person> persons = new ArrayList<>();
}
