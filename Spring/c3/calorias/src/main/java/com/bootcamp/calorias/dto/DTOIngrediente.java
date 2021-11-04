package com.bootcamp.calorias.dto;

public class DTOIngrediente {
    public String name;
    public double peso;

    public DTOIngrediente(String name, double peso) {
        this.name = name;
        this.peso = peso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
