package com.example.calorias.repository;

import com.example.calorias.model.Ingrediente;

import java.util.List;

public interface IPlatoRepository {

    Ingrediente buscarIngredientes(String nombre);
}
