package com.springlll.CalculadoraCalorias.service;

import com.springlll.CalculadoraCalorias.repository.IIngredientesRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientesService implements IIngredientesService{


    IIngredientesRepository ingredientesRepository;

    public IngredientesService(IIngredientesRepository ingredientesRepository) {
        this.ingredientesRepository = ingredientesRepository;
    }

    @Override
    public List<PlatoDTO> obtenerPlato(String nombre) {
        List<Plato> personajes = this.personajeRepository.
                buscarPersonajes(nombre);

        return personajes.stream()
                .map( p -> new PlatoDTO(p) )
                .collect(Collectors.toList());
    }


    @override


}
