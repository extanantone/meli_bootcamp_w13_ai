package com.IOyDI.calculadoraCalorias.service;

import com.IOyDI.calculadoraCalorias.dto.IngredienteDTO;
import com.IOyDI.calculadoraCalorias.entity.Ingrediente;
import com.IOyDI.calculadoraCalorias.repository.IIngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredienteService implements IIngredienteService{

    IIngredienteRepository ingredienteRepository;

    public IngredienteService(IIngredienteRepository ingredienteRepository){
        this.ingredienteRepository = ingredienteRepository;
    }

    @Override
    public List<IngredienteDTO> getIngredientes() {
        List<Ingrediente> ingredientes = this.ingredienteRepository.getAllIngredientes();

        List<IngredienteDTO> ingredienteDTOS = ingredientes.stream()
                .map(IngredienteDTO::new)
                .collect(Collectors.toList());

        return ingredienteDTOS;
    }

    @Override
    public IngredienteDTO getIngredienteByName(String nombre) {
        Ingrediente ingrediente = this.ingredienteRepository.getIngredienteByName(nombre);

        return new IngredienteDTO(ingrediente);
    }
}
