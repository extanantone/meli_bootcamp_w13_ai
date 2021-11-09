package com.example.bootcamp.comida.repository;

import com.example.bootcamp.comida.model.Ingrediente;

import java.util.List;

public interface IIngredienteRepository {

    public List<Ingrediente> traerIngredientes();

    public int obtenerCaloriasPorNombreIngrediente(String nombreIngrediente);



}
