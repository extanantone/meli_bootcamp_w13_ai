package com.springlll.CalculadoraCalorias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class Plato {
    private String nombre;
    private List ingredients;

}
