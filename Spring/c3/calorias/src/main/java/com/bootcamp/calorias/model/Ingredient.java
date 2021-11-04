package com.bootcamp.calorias.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Ingredient {
    private String name;
    private double calories;

    public Ingredient(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }

    public Ingredient() {
    }
}
