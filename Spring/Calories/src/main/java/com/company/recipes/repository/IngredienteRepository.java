package com.company.recipes.repository;

import com.company.recipes.dto.IngredienteDTO;
import com.company.recipes.dto.PlatoDTO;
import com.company.recipes.model.Ingrediente;
import com.company.recipes.model.Plato;

import java.util.List;

public interface IngredienteRepository {

    List<Ingrediente> getIngredientes(PlatoDTO plato);

    Integer getCalorias(List<IngredienteDTO> ingredientes);

    Ingrediente getIngredienteByName(String name);

}
