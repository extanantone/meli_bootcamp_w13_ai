package com.bootcamp.caloriescalculator.dto;

import com.bootcamp.caloriescalculator.model.Ingredient;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class IngredientResDTO extends Ingredient {

    public IngredientResDTO() {
    }

    public IngredientResDTO(String name, int calories) {
        super(name, calories);
    }
}
