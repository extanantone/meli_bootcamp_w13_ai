package com.example.calculadoracalorias.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngredientDTO {
    private String name;
    private double weight;
    private double calories;
    private double caloriesByWeight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getCaloriesByWeight() {
        return caloriesByWeight;
    }

    public void setCaloriesByWeight(double caloriesByWeight) {
        this.caloriesByWeight = caloriesByWeight;
    }
}
