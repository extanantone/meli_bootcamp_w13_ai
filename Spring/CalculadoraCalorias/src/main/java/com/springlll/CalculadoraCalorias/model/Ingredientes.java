package com.springlll.CalculadoraCalorias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredientes {
    private String nombre;
    private int calorias;
}
