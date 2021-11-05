package com.example.c3_ioc_inyec_depen_vivo_p2.service;

import com.example.c3_ioc_inyec_depen_vivo_p2.dto.CaloriasDTO;
import com.example.c3_ioc_inyec_depen_vivo_p2.model.Ingrediente;
import com.example.c3_ioc_inyec_depen_vivo_p2.model.Plato;
import com.example.c3_ioc_inyec_depen_vivo_p2.repository.ICaloriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CaloriasService implements ICaloriasService
{
    @Autowired
    ICaloriasRepository caloriasRepository;

    private int getTotalCalories(Ingrediente ingrediente)
    {
        return ingrediente.getCalories() * ingrediente.getPeso();
    }

    private long consulCalorias(Plato plato)
    {
        return plato.getIngredienteList().stream().collect(Collectors.summarizingInt(this::getTotalCalories)).getSum();
    }

    private Map<String, Integer> ingredientesCals(Plato plato)
    {
        return plato.getIngredienteList().stream().collect(Collectors.toMap(Ingrediente::getName, this::getTotalCalories));
    }

    private String ingredienteMaxCal(Plato plato)
    {
        Map<String, Integer> ingredienteDict = ingredientesCals(plato);
        return Collections.max(ingredienteDict.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    private List<Ingrediente> matchCalories(Plato plato)
    {
        Map<String, Integer> ingredientesCal = caloriasRepository.ingredientesDict();
        System.out.println(ingredientesCal);
        for (Ingrediente ingrediente: plato.getIngredienteList())
        {
            if (ingredientesCal.containsKey(ingrediente.getName().toLowerCase(Locale.ROOT)))
            {
                ingrediente.setCalories(ingredientesCal.get(ingrediente.getName().toLowerCase(Locale.ROOT)));
            }
        }
        return plato.getIngredienteList();
    }

    @Override
    public List<CaloriasDTO> calcularParametros(List<Plato> platos)
    {

        List<CaloriasDTO> caloriasDTOList = new ArrayList<>();
        for (Plato plato : platos)
        {
            matchCalories(plato);
            CaloriasDTO caloriasDTO = new CaloriasDTO();
            caloriasDTO.setPlatoNombre(plato.getNombre());
            caloriasDTO.setTotalCalorias(consulCalorias(plato));
            caloriasDTO.setIngredientesCals(ingredientesCals(plato));
            caloriasDTO.setIngredienteMaxCal(ingredienteMaxCal(plato));
            caloriasDTOList.add(caloriasDTO);
        }
        return (caloriasDTOList);
    }
}
