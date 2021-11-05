package com.Spring.C3P2.CalculadoraCalorias.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    private String name;
    private List<IngredienteDTO> ingredients;
}
