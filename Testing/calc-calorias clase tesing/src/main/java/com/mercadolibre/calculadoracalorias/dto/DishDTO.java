package com.mercadolibre.calculadoracalorias.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
  private String name;
  private List<IngredientDTO> ingredients;
}
