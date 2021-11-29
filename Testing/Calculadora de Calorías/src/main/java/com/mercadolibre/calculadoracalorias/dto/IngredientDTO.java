package com.mercadolibre.calculadoracalorias.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class IngredientDTO {
  private String name;
  private Integer calories;
  private Integer weight;

  public IngredientDTO(String name, int calories) {
    this.name = name;
    this.calories = calories;
  }
}
