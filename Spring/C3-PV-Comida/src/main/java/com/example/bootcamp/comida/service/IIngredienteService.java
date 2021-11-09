package com.example.bootcamp.comida.service;

import com.example.bootcamp.comida.dto.IngredienteDTO;
import com.example.bootcamp.comida.model.Plato;

import java.util.List;

public interface IIngredienteService {

    public void obtenerIngredientes();
    public int obtenerCaloriasPorNombreIngrediente(String ingredienteNombre);
    public int calcularCaloriasDeIngredientesPorPlato (Plato p);
    public List<IngredienteDTO> obtenerIngredientesPorPlato (Plato p);


}
