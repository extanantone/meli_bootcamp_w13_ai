package com.example.calculadora_calorias.services;

import com.example.calculadora_calorias.dto.IngredienteDTO;
import com.example.calculadora_calorias.repositorio.Comida;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcularCaloriasService {
    private final Comida ingredientRepository;

    public CalcularCaloriasService(Comida ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    public Integer calcularCalorias(List<IngredienteDTO> listaIngredientes){
        int acumulador = 0;
        for(IngredienteDTO ing: listaIngredientes){
            Integer calorias = ingredientRepository.buscarIngredientePorNombre(ing.getNombre()).getCalorias();
            acumulador += (int)((calorias * ing.getPeso())/100.f);
        }
        return acumulador;
    }
}
