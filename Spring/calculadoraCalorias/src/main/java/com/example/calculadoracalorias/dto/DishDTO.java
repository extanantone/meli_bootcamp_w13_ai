package com.example.calculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class DishDTO {
    private String name;
    private List<IngredientDTO> ingredients;
    private String MoreCaloricIngredient;

}
