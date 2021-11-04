package com.bootcamp.calorias.dto;


import java.util.List;

public class DTOCalories {
    private double totalDeCalorias;
    private List ingredientesYCalorias;
    private String ingredienteConMasCalorias;

    public DTOCalories(double totalDeCalorias, List ingredientesYCalorias, String ingredienteConMasCalorias) {
        this.totalDeCalorias = totalDeCalorias;
        this.ingredientesYCalorias = ingredientesYCalorias;
        this.ingredienteConMasCalorias = ingredienteConMasCalorias;
    }

    public double getTotalDeCalorias() {
        return totalDeCalorias;
    }

    public void setTotalDeCalorias(double totalDeCalorias) {
        this.totalDeCalorias = totalDeCalorias;
    }

    public List getIngredientesYCalorias() {
        return ingredientesYCalorias;
    }

    public void setIngredientesYCalorias(List ingredientesYCalorias) {
        this.ingredientesYCalorias = ingredientesYCalorias;
    }

    public String getIngredienteConMasCalorias() {
        return ingredienteConMasCalorias;
    }

    public void setIngredienteConMasCalorias(String ingredienteConMasCalorias) {
        this.ingredienteConMasCalorias = ingredienteConMasCalorias;
    }
}
