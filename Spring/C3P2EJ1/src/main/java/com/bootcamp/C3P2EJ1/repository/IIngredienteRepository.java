package com.bootcamp.C3P2EJ1.repository;

import com.bootcamp.C3P2EJ1.model.Ingrediente;

import java.util.List;

public interface IIngredienteRepository {
    public List<Ingrediente> buscarIngredientes(String nombre);
}
