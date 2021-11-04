package com.example.calorias.repository;

import com.example.calorias.model.Ingredientes;

import java.util.List;

public interface ICaloriasRepositorio {
    public Ingredientes obtenerIngrediente(String nombre);
    public List<Ingredientes> todosLosIngredientes();
}
