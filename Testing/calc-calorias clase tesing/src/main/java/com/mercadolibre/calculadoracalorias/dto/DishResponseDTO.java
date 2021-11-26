package com.mercadolibre.calculadoracalorias.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class DishResponseDTO extends DishDTO {
  private Integer calories;
  private IngredientDTO caloric;

  public DishResponseDTO(DishDTO dish) {
    super();
    this.setIngredients(dish.getIngredients());
    this.setName(dish.getName());
  }
}
