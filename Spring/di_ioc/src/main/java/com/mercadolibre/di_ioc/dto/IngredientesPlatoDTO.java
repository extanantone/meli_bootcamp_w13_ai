package com.mercadolibre.di_ioc.dto;

import com.mercadolibre.di_ioc.model.IngredientesReceta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientesPlatoDTO {
    private String nombre;
    private List<IngredientesReceta> ingredientesRecetaList;
}
