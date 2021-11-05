package com.C3P2VIVO.CalculadoraCalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlatoCalculadoDTO extends PlatoDTO {
    private Integer totalCalories;
    private IngredienteDTO ingredienteMax;

    public PlatoCalculadoDTO(PlatoDTO platoDTO) {
        this.setIngredientes(platoDTO.getIngredientes());
        this.setName(platoDTO.getName());
    }
}
