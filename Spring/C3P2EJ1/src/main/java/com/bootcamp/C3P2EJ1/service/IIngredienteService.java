package com.bootcamp.C3P2EJ1.service;

import com.bootcamp.C3P2EJ1.dto.IngredienteDTO;
import com.bootcamp.C3P2EJ1.dto.PlatoDTO;

import java.util.List;

public interface IIngredienteService {
    public List<IngredienteDTO> obtenerIngredientes(PlatoDTO platoDTO);

    public double cantidadTotalCalorias(PlatoDTO platoDTO);

    public List<String> obtenerListaIngredientes(PlatoDTO platoDTO);

    public IngredienteDTO ingredienteMayorCaloria(PlatoDTO platoDTO);
}
