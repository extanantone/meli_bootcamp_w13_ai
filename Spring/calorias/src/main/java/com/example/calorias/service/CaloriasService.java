package com.example.calorias.service;

import com.example.calorias.dto.ingredienteDto;
import com.example.calorias.dto.platoDto;
import com.example.calorias.exceptions.NullPointerException;
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
            if (ing == null){
                throw new NullPointerException("No se encontró el ingrediente");
            }else {
                calorias += (in.getPeso() * ing.getCalories()) / 100;
            }
        }
        return calorias;
    }

    public Ingredientes obtenerIngredienteConMasCalorias() {
        int calorias =0;
        Ingredientes ingredi = new Ingredientes();
        List<Ingredientes> ingredientesPlato = repo.todosLosIngredientes();;
        for (Ingredientes in: ingredientesPlato) {
            if(in.getCalories()>calorias){
                calorias = in.getCalories();
                ingredi = in;
            }
        }
        return ingredi;
    }
}
