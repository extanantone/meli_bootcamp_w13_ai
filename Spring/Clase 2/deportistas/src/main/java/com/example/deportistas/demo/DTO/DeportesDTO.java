package com.example.deportistas.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DeportesDTO implements Serializable {
    private String name;
    private int nivel;


}
