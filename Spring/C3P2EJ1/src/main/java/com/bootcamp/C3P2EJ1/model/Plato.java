package com.bootcamp.C3P2EJ1.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Plato {
    private String nombre;
    private List<Ingrediente> listaIngredientes;
}
