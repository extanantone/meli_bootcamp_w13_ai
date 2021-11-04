package com.example.calculadoracalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Plato {
    private String nombre;
    private List<Ingrediente> ingredientes;
}
