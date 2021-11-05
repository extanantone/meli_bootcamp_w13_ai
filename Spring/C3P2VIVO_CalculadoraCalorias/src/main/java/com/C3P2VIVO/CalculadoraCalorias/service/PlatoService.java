package com.C3P2VIVO.CalculadoraCalorias.service;

import com.C3P2VIVO.CalculadoraCalorias.dto.IngredienteDTO;
import com.C3P2VIVO.CalculadoraCalorias.dto.PlatoCalculadoDTO;
import com.C3P2VIVO.CalculadoraCalorias.dto.PlatoDTO;
import com.C3P2VIVO.CalculadoraCalorias.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoService implements IPlatoService{
    private final IngredienteRepository ingredienteRepository;

    public PlatoService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    @Override
    public PlatoCalculadoDTO calcularCalories(PlatoDTO platoDTO) {
        PlatoCalculadoDTO response = new PlatoCalculadoDTO(platoDTO);
        int total = 0;
        int maxCalories = 0;

        for(IngredienteDTO ingredienteDTO: response.getIngredientes()){
            calculateIngredientCalories(ingredienteDTO);
            total += ingredienteDTO.getCalories();
            if(ingredienteDTO.getCalories() > maxCalories){
                response.setIngredienteMax(ingredienteDTO);
            }
        }
        response.setTotalCalories(total);

        return response;
    }

    @Override
    public List<PlatoCalculadoDTO> calcularCaloriesPlatos(List<PlatoDTO> platosDTO) {
        List<PlatoCalculadoDTO> result = new ArrayList<>();
        for(PlatoDTO platoDTO : platosDTO){
            result.add(this.calcularCalories(platoDTO));
        }

        return result;
    }

    private void calculateIngredientCalories(IngredienteDTO ingrediente){
        ingrediente.setCalories(0);
        IngredienteDTO ingredientFromRepository = ingredienteRepository.findIngredientByName(ingrediente.getName());
        if(ingredientFromRepository != null)
            ingrediente.setCalories((int)(ingrediente.getWeight() * ingredientFromRepository.getCalories() / 100.f));

    }
}
