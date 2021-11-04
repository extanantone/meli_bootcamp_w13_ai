package com.c3.p2.service;

import com.c3.p2.dto.CaloriasDto;
import com.c3.p2.dto.IngredienteDto;
import com.c3.p2.dto.PlatoDto;
import com.c3.p2.model.Ingrediente;
import com.c3.p2.repository.IIngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaloriasService implements ICaloriasService{

    IIngredienteRepository platosRepository;

    public CaloriasService(IIngredienteRepository platosRepository){
        this.platosRepository = platosRepository;
    }

    @Override
    public CaloriasDto calcularCaloriasPlato(PlatoDto plato) {
        CaloriasDto caloriasDto = new CaloriasDto();
        List<Ingrediente> ingredientes = platosRepository.obtenerIngredientes().stream().filter(i ->
                plato.getIngredienteList().stream().map(IngredienteDto::getName).collect(Collectors.toList()).contains(i.getName()))
                .collect(Collectors.toList());
        if (ingredientes.size() > 0){
            ingredientes.forEach(i -> i.setCalories(i.getCalories() *
                    plato.getIngredienteList().stream().filter(iDto -> iDto.getName().equals(i.getName())).findFirst().get().getWeight()
                    / 100));
            caloriasDto.setIngredientes(ingredientes);
            caloriasDto.setTotalCalorias(ingredientes.stream().mapToDouble(Ingrediente::getCalories).sum());
            Double maximasCalorias = ingredientes.stream().mapToDouble(Ingrediente::getCalories).max().getAsDouble();
            caloriasDto.setIngredienteMasCalorico((Ingrediente) ingredientes.stream().filter(i -> i.getCalories().equals(maximasCalorias)).findFirst().orElse(null));
        }
        return caloriasDto;
    }

    @Override
    public List<CaloriasDto> calcularCaloriasListaPlatos(List<PlatoDto> platosList) {
        List<CaloriasDto> caloriasDtoList = new ArrayList<>();
        for ( PlatoDto plato: platosList) {
            caloriasDtoList.add(calcularCaloriasPlato(plato));
        }
        return caloriasDtoList;
    }
}
