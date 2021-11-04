package com.example.calorias.service;

import com.example.calorias.dto.platoDto;
import com.example.calorias.model.Ingredientes;

public interface ICaloriasService {
    public int obtenerCalorias(platoDto plato);
    public Ingredientes obtenerIngredienteConMasCalorias();
}
