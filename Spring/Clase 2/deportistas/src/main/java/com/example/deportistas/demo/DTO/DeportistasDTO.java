package com.example.deportistas.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class DeportistasDTO implements Serializable {
    private String nombre;
    private String apellido;
    private Integer edad;


}
