package com.bootcamp.calculadora_de_calorias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {

    private String name;
    private Double calories;

}
