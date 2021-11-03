package com.bootcamp.C2P2EJ1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//Tuve que crear la clase en minúscula por un problea con Intellij
@Getter
@Setter
@AllArgsConstructor
public class persona {
    private String nombre;
    private String apellido;
    private int edad;
    private List<Deporte> deportes;
}
