package com.mercadolibre.di_ioc.dto;

import com.mercadolibre.di_ioc.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlatoCaloriasDTO {
    private String nombre;
    private int totalCalorias;
    private List<Ingrediente> listaIngredientes;
    private Ingrediente mayorEnCalorias;
}
