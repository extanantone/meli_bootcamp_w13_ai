package com.example.plato.repository;

import com.example.plato.model.Ingrediente;

import java.util.List;

public interface ICaloriasRepository {

    public Ingrediente getIngrediente(String name);
}
