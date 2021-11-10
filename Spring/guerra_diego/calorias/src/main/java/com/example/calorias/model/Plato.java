package com.example.calorias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plato {

    private String nombre;
    private int peso;
    List<Ingrediente> ingredientes;
}
