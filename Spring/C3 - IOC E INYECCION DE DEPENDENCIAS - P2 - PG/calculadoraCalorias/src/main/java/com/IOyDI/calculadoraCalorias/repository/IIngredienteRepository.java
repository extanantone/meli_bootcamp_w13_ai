package com.IOyDI.calculadoraCalorias.repository;

import com.IOyDI.calculadoraCalorias.dto.IngredienteDTO;
import com.IOyDI.calculadoraCalorias.entity.Ingrediente;

import java.util.List;

public interface IIngredienteRepository {
    List<Ingrediente> getAllIngredientes();

    Ingrediente getIngredienteByName(String nombre);
}
