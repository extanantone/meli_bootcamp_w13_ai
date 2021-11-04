package com.bootcamp.calculadora_de_calorias.service;

import com.bootcamp.calculadora_de_calorias.dto.IngredienteDTO;
import com.bootcamp.calculadora_de_calorias.model.Ingrediente;

import java.util.List;

public interface IPlatoService {

    public Double calcularCalorias(List<IngredienteDTO> ingredientes);

    public List<Ingrediente> getIngredientesAndCalorias(List<IngredienteDTO> ingredientes);

    public String getIngredienteMaxCalorias(List<IngredienteDTO> ingredientes);

}
