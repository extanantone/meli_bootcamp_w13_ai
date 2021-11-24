package com.bootcamp.calculadorDeCalorias.service;

import com.bootcamp.calculadorDeCalorias.dto.InfoPlatoDTO;
import com.bootcamp.calculadorDeCalorias.dto.IngredientesDTO;
import com.bootcamp.calculadorDeCalorias.dto.PlatoDTO;
import com.bootcamp.calculadorDeCalorias.repository.IIngredientesRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class PlatoService implements IPlatoService{
    IIngredientesRepository iIngredientesRepository;

    public PlatoService(IIngredientesRepository iIngredientesRepository) {
        this.iIngredientesRepository = iIngredientesRepository;
    }

    @Override
    public InfoPlatoDTO getInfoPlato(PlatoDTO inPlato) {
        HashMap<String,Double> outIngredientCalories =new HashMap<String,Double>();
        for(IngredientesDTO i : inPlato.getIngredientes()) {
            Integer caloriesRate = this.iIngredientesRepository.getIngredientesByName(i.getName());

            outIngredientCalories.put(i.getName(), ((double) caloriesRate * ()));
        }
    }
}
