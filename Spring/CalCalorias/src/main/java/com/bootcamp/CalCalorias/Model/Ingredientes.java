package com.bootcamp.CalCalorias.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingredientes {
    private String nombre;
    private Integer calorias;
    private Integer peso;
}
