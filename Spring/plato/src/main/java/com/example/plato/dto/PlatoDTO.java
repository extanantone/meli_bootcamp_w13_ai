package com.example.plato.dto;

import com.example.plato.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    private List<IngredienteDTO> ingredientes;
    private String ingredienteMasCalorias;
    private Double totalCalorias;
}
