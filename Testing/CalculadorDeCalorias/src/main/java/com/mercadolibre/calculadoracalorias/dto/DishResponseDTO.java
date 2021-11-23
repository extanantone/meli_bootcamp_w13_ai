package com.mercadolibre.calculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishResponseDTO extends DishDTO {
  private Integer calories;
  private IngredientDTO caloric;

  public DishResponseDTO(DishDTO dish) {
    this.setIngredients(dish.getIngredients());
    this.setName(dish.getName());
  }
}
