package com.miprimerproyecto.pruebaspring.service;

import com.miprimerproyecto.pruebaspring.dto.IngredientesDTO;
import com.miprimerproyecto.pruebaspring.dto.PlatoDTO;
import com.miprimerproyecto.pruebaspring.dto.PlatoDevueltoDTO;
import com.miprimerproyecto.pruebaspring.model.Ingrediente;
import com.miprimerproyecto.pruebaspring.repository.IIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@Service
public class PlatoService implements IPlatoService{
    @Autowired
    IIngredienteRepository iIngredienteRepository;

    @Override
    public PlatoDevueltoDTO getPlato(PlatoDTO platoDTO) {

        PlatoDevueltoDTO platoDevueltoDTO = new PlatoDevueltoDTO();

        platoDevueltoDTO.setNamePlato(platoDTO.getName());

        List<Ingrediente> ingredientes = new ArrayList<>();
        Ingrediente ingrediente;
        for (IngredientesDTO ingredientesDTO: platoDTO.getIngredientesDTOS()) {

            ingrediente =iIngredienteRepository.getIngredientes(ingredientesDTO.getName());

            ingredientes.add(new Ingrediente( ingrediente.getName(),
                    (ingrediente.getCalories()*ingredientesDTO.getPeso())

            ));
        }

        platoDevueltoDTO.setIngredientes(ingredientes);
        platoDevueltoDTO.setCaloriastotal((int) ingredientes.stream().mapToDouble(i-> i.getCalories()).sum());
        platoDevueltoDTO.setIngredienteConMasCalorias(
        ingredientes.stream().max(Comparator.comparing(ingrediente1 -> ingrediente1.getCalories())).get().getName());

        return platoDevueltoDTO;
    }

    @Override
    public List<PlatoDevueltoDTO> getPlatos(List<PlatoDTO> platoDTOs) {
        return null;
    }
}
