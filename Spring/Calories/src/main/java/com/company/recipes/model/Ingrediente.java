package com.company.recipes.model;

import com.company.recipes.dto.IngredienteDTO;
import com.company.recipes.repository.impl.IngredienteRepositoryImpl;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Ingrediente {

    private String name;
    private int calories;

    public Ingrediente(IngredienteDTO ingredienteDTO) {
        this.setName(ingredienteDTO.getNombre());
        this.setCalories(ingredienteDTO.getCalorias());
    }
}
