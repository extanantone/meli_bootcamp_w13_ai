package com.Spring.C3P2.CalculadoraCalorias.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
    private String name;
    private int calories;
}
