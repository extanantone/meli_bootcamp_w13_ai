package com.bootcamp.C3P2EJ1.dto;

import com.bootcamp.C3P2EJ1.model.Ingrediente;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IngredienteDTO {
    private String name;
    private Integer calories;
    private Double weight;

    public IngredienteDTO(Ingrediente ingrediente) {
        this.name = ingrediente.getName();
        this.calories = ingrediente.getCalories();
        this.weight = ingrediente.getWeight();
    }


}
