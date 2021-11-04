package com.miprimerproyecto.pruebaspring.repository;

import com.miprimerproyecto.pruebaspring.model.Ingrediente;

import java.util.List;

public interface IIngredienteRepository {

    Ingrediente getIngredientes(String name);
}
