package com.company.recipes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String name;
    @JsonProperty("ingredientes")
    private List<IngredienteDTO> ingredientes;

    @Override
    public String toString() {
        return "PlatoDTO{" +
                "name='" + name + '\'' +
                ", ingredientes=" + ingredientes +
                '}';
    }
}
