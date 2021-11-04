package com.bootcamp.CalCalorias.Repository;

import com.bootcamp.CalCalorias.Model.Ingredientes;

public interface IIngredienteRepository {
    Ingredientes getNombreIngrediente(String nombre);
}
