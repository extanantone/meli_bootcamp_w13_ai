package com.bootcamp.caloriescalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishReqDTO {

    String name;
    List<IngredientReqDTO> ingredients;

}
