package com.miprimerproyecto.pruebaspring.dto;

import com.miprimerproyecto.pruebaspring.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class IngredientesDTO {

    private String name;
    private int peso;
}
