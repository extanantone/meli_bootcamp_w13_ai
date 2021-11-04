package com.bootcamp.calorias.repository;

public interface ICaloriesRepository {
    public double getCalories(String nombre);

    public void cargarIngredientes();
}
