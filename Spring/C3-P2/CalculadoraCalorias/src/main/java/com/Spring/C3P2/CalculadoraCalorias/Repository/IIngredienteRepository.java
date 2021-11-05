package com.Spring.C3P2.CalculadoraCalorias.Repository;

import com.Spring.C3P2.CalculadoraCalorias.Model.Ingrediente;

public interface IIngredienteRepository {
    public Ingrediente ObtenerIngrediente (String nombre);
}
