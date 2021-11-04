package com.example.calorias.repository;

import com.example.calorias.model.Ingredientes;

public interface ICaloriasRepositorio {
    public Ingredientes obtenerIngrediente(String nombre);
}
