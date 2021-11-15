package com.springlll.CalculadoraCalorias.repository;

import com.springlll.CalculadoraCalorias.model.Ingredientes;

import java.util.List;

public interface IIngredientesRepository {
    List<Ingredientes> abrirIngredientes (String nombre);
}
