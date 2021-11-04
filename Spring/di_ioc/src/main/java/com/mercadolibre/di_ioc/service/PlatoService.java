package com.mercadolibre.di_ioc.service;

import com.mercadolibre.di_ioc.dto.IngredientesPlatoDTO;
import com.mercadolibre.di_ioc.dto.PlatoCaloriasDTO;
import com.mercadolibre.di_ioc.model.Ingrediente;
import com.mercadolibre.di_ioc.model.IngredientesReceta;
import com.mercadolibre.di_ioc.repository.IPlatoRepository;
import com.mercadolibre.di_ioc.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class PlatoService {
    @Autowired
    IPlatoRepository iPlatoRepository;

    public List<PlatoCaloriasDTO> totalCalorias(IngredientesPlatoDTO[] mPlatos){
        List<PlatoCaloriasDTO> returnList = new ArrayList<>();
        for(IngredientesPlatoDTO mIngredientesPlatoDTO: mPlatos) {
            List<Ingrediente> mListaOriginal = iPlatoRepository.abrirIngredienteJSON();
            List<IngredientesReceta> mListaIngredientes = mIngredientesPlatoDTO.getIngredientesRecetaList();

            List<Ingrediente> tempList = ingredientesList(mListaOriginal, mListaIngredientes);
            Ingrediente mayorEnCalorias = tempList.stream().max(Comparator.comparing(Ingrediente::getCalories)).get();
            int totalCalorias = tempList.stream().mapToInt(Ingrediente::getCalories).sum();

            PlatoCaloriasDTO platoCaloriasDTO = new PlatoCaloriasDTO();
            platoCaloriasDTO.setNombre(mIngredientesPlatoDTO.getNombre());
            platoCaloriasDTO.setTotalCalorias(totalCalorias);
            platoCaloriasDTO.setMayorEnCalorias(mayorEnCalorias);
            platoCaloriasDTO.setListaIngredientes(tempList);

            returnList.add(platoCaloriasDTO);
        }

        return returnList;
    }

    public List<Ingrediente> ingredientesList(List<Ingrediente> mListaOriginal, List<IngredientesReceta> mListaReceta){
        return mListaOriginal.stream()
                .filter(ingrediente -> mListaReceta.stream()
                    .map(IngredientesReceta::getNombre)
                    .collect(Collectors.toList()).contains(ingrediente.getName()))
                .map(nIngrediente -> new Ingrediente(nIngrediente.getName(), mListaReceta.stream().filter(
                        ingredientesReceta -> ingredientesReceta.getNombre().equals(nIngrediente.getName())
                )
                        .findFirst().orElse(new IngredientesReceta("No encontro el ingrediente "
                                + nIngrediente.getName(), 0)).getPeso() * nIngrediente.getCalories()
                ))
                .collect(Collectors.toList());
    }

}
