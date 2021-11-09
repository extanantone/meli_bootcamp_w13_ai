package com.bootcamp.C3P2EJ1.service;

import com.bootcamp.C3P2EJ1.dto.IngredienteDTO;
import com.bootcamp.C3P2EJ1.dto.PlatoDTO;
import com.bootcamp.C3P2EJ1.model.Ingrediente;
import com.bootcamp.C3P2EJ1.repository.IIngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredienteServiceImp implements IIngredienteService {
    IIngredienteRepository iIngredienteRepository;

    public IngredienteServiceImp(IIngredienteRepository iIngredienteRepository) {
        this.iIngredienteRepository = iIngredienteRepository;
    }

    @Override
    public List<IngredienteDTO> obtenerIngredientes(PlatoDTO platoDTO) {
        List<Ingrediente> ingredientes = platoDTO.getListaIngredientes();
        return ingredientes.stream()
                .map(ingrediente -> new IngredienteDTO(ingrediente.getName(), buscarIngredienteNombre(ingrediente.getName()).getCalories(), ingrediente.getWeight()))
                .collect(Collectors.toList());
    }

    @Override
    public double cantidadTotalCalorias(PlatoDTO platoDTO) {
        return obtenerIngredientes(platoDTO).stream()
                .mapToDouble(ingredienteDTO -> ingredienteDTO.getCalories() * ingredienteDTO.getWeight())
                .sum();
    }

    @Override
    public List<String> obtenerListaIngredientes(PlatoDTO platoDTO) {
        return obtenerIngredientes(platoDTO).stream()
                .map(ingredienteDTO -> ingredienteDTO.getName() + ", calorías: " + (ingredienteDTO.getWeight() * ingredienteDTO.getCalories())/100.f)
                .collect(Collectors.toList());
    }

    @Override
    public IngredienteDTO ingredienteMayorCaloria(PlatoDTO platoDTO) {
        return obtenerIngredientes(platoDTO).stream()
                .max(Comparator.comparing(ingredienteDTO -> (ingredienteDTO.getWeight() * ingredienteDTO.getCalories())/100.f))
                .get();
    }

    private Ingrediente buscarIngredienteNombre(String nombre) {
        return iIngredienteRepository.buscarIngredientes(nombre).get(0);
    }
}
