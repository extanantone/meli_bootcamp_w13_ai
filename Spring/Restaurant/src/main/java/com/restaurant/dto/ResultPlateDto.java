package com.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResultPlateDto {
    private double fullCalories;
    private String mostClaoriesIngredienteName;
    private List<ResultIngredientDto> ingredients;
}
