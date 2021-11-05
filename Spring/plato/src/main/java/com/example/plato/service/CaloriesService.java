package com.example.plato.service;

import com.example.plato.dto.IngredienteDTO;
import com.example.plato.dto.PlatoDTO;
import com.example.plato.model.IngredientPlato;
import com.example.plato.model.Ingrediente;
import com.example.plato.model.Plato;
import com.example.plato.repository.ICaloriasRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CaloriesService implements ICaloriesService {

    ICaloriasRepository caloriasRepository;

    public CaloriesService(ICaloriasRepository caloriasRepository) {
        this.caloriasRepository = caloriasRepository;
    }

    public  Double calcularCalorias (IngredientPlato ing) {

        Ingrediente ingrediente = caloriasRepository.getIngrediente(ing.getName());

        return (ing.getPeso()*ingrediente.getCalories())/100D;
    }
    @Override
    public PlatoDTO getCalorias(Plato platoM) {

        PlatoDTO platoResult = new PlatoDTO();
        List<IngredientPlato> ingredientes = platoM.getIngredientes();

        List <IngredienteDTO> ingCalculo = ingredientes
                .stream().map(ing -> new IngredienteDTO(ing.getName(),calcularCalorias(ing)))
                .collect(Collectors.toList());

        platoResult.setIngredientes(ingCalculo);
        platoResult.setTotalCalorias(ingCalculo
                .stream()
                .mapToDouble(x -> x.getCalorias())
                .summaryStatistics()
                .getSum());
        platoResult.setIngredienteMasCalorias(ingCalculo
                .stream()
                .sorted(Comparator.comparing(IngredienteDTO::getCalorias).reversed())
                .collect(Collectors.toList())
                .get(0)
                .getName());
        return platoResult;
    }
}
