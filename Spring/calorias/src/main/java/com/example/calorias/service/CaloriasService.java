package com.example.calorias.service;

import com.example.calorias.dto.ingredienteDto;
import com.example.calorias.dto.platoDto;
import com.example.calorias.model.Ingredientes;
import com.example.calorias.repository.ICaloriasRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CaloriasService implements ICaloriasService{
    ICaloriasRepositorio repo;

    public CaloriasService(ICaloriasRepositorio repo) {
        this.repo = repo;
    }

    @Override
    public int obtenerCalorias(platoDto plato) {
        int calorias =0;
        List<ingredienteDto> ingredientesPlato = plato.getIngredientes();
        for (ingredienteDto in: ingredientesPlato) {
            Ingredientes ing = repo.obtenerIngrediente(in.getNombre());
            calorias += (in.getPeso()*ing.getCalories())/100;
        }
        return calorias;
    }
}
