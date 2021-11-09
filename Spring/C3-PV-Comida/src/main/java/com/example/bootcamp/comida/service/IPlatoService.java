package com.example.bootcamp.comida.service;

import com.example.bootcamp.comida.dto.CaloriasTotalesDTO;
import com.example.bootcamp.comida.dto.IngredienteDTO;
import com.example.bootcamp.comida.dto.PlatoDTO;
import com.example.bootcamp.comida.dto.PlatoPesoDTO;
import com.example.bootcamp.comida.model.Plato;

import java.util.List;

public interface IPlatoService {

    public void crearPlato (PlatoDTO p);

    public List<PlatoDTO> obtenerPlatos();

    public Plato obtenerPlatoPorNombre(String platoName);

    public CaloriasTotalesDTO obtenerCaloriasPorGramos(PlatoPesoDTO platoPesoDto);

    public List<IngredienteDTO> obtenerIngredientesPorPlato (PlatoDTO p);

    public IngredienteDTO obtenerIngredienteConMayorCaloria(PlatoDTO plato);

}
