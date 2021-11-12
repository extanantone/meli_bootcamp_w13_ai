package com.bootcamp.calculadoraCalorias.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Dish {
    private String name;
    private double weight;
    private List<Ingredient> ingredients;

}
