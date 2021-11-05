package com.MeliBoot.food.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plato {

    private String nombre;
    private List<Ingrediente> ingredientes;

}
