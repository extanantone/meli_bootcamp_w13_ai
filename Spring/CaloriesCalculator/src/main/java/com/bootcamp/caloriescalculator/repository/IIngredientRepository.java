package com.bootcamp.caloriescalculator.repository;

import com.bootcamp.caloriescalculator.model.Ingredient;

public interface IIngredientRepository {

    public Ingredient getIngredientByName(String name);
}
