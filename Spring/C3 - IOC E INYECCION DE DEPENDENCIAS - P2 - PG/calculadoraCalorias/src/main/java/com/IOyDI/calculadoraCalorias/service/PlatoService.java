package com.IOyDI.calculadoraCalorias.service;

import com.IOyDI.calculadoraCalorias.dto.IngredienteDTO;
import com.IOyDI.calculadoraCalorias.dto.PlatoDTO;
import com.IOyDI.calculadoraCalorias.entity.Ingrediente;
import com.IOyDI.calculadoraCalorias.repository.IIngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoService implements IPlatoService{
    IIngredienteRepository ingredienteRepository;

    public PlatoService(IIngredienteRepository ingredienteRepository){
        this.ingredienteRepository = ingredienteRepository;
    }

    @Override
    public Double getCalorias(PlatoDTO plato) {
        Double calorias = 0.0;
        for (IngredienteDTO ingrediente: plato.getIngredientes()){
            Ingrediente getIngrediente = ingredienteRepository.getIngredienteByName(ingrediente.getNombre());
            if (getIngrediente != null){
                calorias+= (getIngrediente.getCalories() * ingrediente.getGramos()) / 100;
            }
        }
        return calorias;
    }

    public List<IngredienteDTO> getIngredientes(PlatoDTO plato) {
        List<IngredienteDTO> ingredientes = new ArrayList<>();
        for (IngredienteDTO ingrediente: plato.getIngredientes()){
            Ingrediente getIngrediente = ingredienteRepository.getIngredienteByName(ingrediente.getNombre());
            if (getIngrediente != null){
                ingrediente.setCalorias(getIngrediente.getCalories());
                ingredientes.add(ingrediente);
            }
        }

        return ingredientes;
    }

    @Override
    public IngredienteDTO getIngredienteMasCalorias(PlatoDTO plato) {
        IngredienteDTO ingredienteDTO = new IngredienteDTO();
        for (IngredienteDTO ingrediente: plato.getIngredientes()){
            Ingrediente getIngrediente = ingredienteRepository.getIngredienteByName(ingrediente.getNombre());
            if (getIngrediente != null && getIngrediente.getCalories() > ingredienteDTO.getCalorias()){
                ingredienteDTO.setNombre(ingrediente.getNombre());
                ingredienteDTO.setGramos(ingrediente.getGramos());
                ingredienteDTO.setCalorias(getIngrediente.getCalories());
            }
        }
        return ingredienteDTO;
    }


}
