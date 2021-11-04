package com.bootcamp.calculadora_de_calorias.repository;

import com.bootcamp.calculadora_de_calorias.model.Ingrediente;

public interface IIngredienteRepository {

    public Double getCalorias(String nombreIngrediente);

}
