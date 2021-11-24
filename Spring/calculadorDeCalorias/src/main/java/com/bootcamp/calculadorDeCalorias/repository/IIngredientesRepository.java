package com.bootcamp.calculadorDeCalorias.repository;

import com.bootcamp.calculadorDeCalorias.model.Ingredientes;

import java.util.List;

public interface IIngredientesRepository {
    public List<Ingredientes> abrirIngredientesJSON();
    public Ingredientes getIngredientesByName(String name);
}
