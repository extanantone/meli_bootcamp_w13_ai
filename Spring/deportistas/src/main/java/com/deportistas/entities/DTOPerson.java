package com.deportistas.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DTOPerson {
    private String Name;
    private String LastName;
    private int Age;
    private List<DTOSport> sports = new ArrayList<>();
}
