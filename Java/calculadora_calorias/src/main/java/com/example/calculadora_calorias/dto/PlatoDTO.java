package com.example.calculadora_calorias.dto;

import java.util.List;

public class PlatoDTO {
    private String name;
    private List<IngredienteDTO> ingredients;

    public PlatoDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredienteDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredienteDTO> ingredients) {
        this.ingredients = ingredients;
    }
}
