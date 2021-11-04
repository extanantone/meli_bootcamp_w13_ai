package com.bootcamp.caloriescalculator.dto;

import com.bootcamp.caloriescalculator.model.Ingredient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientResDTO extends Ingredient {

    public IngredientResDTO() {
    }

    public IngredientResDTO(String name, int calories) {
        super(name, calories);
    }
}
