package com.example.bootcamp.comida.service;

import ch.qos.logback.core.pattern.Converter;
import com.example.bootcamp.comida.dto.CaloriasTotalesDTO;
import com.example.bootcamp.comida.dto.IngredienteDTO;
import com.example.bootcamp.comida.dto.PlatoDTO;
import com.example.bootcamp.comida.dto.PlatoPesoDTO;
import com.example.bootcamp.comida.mapper.PlatoMapper;
import com.example.bootcamp.comida.model.Ingrediente;
import com.example.bootcamp.comida.model.Plato;
import com.example.bootcamp.comida.repository.IPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;


@Service
public class PlatoService implements IPlatoService{

    @Autowired
    private IPlatoRepository platoRepository;
    @Autowired
    private IIngredienteService ingredienteService;


    @Override
    public void crearPlato(PlatoDTO p) {

        Plato plato = new Plato();
        plato = PlatoMapper.PlatoDTOToPlato(p);
        platoRepository.guardarPlato(plato);

    }

    @Override
    public List<PlatoDTO> obtenerPlatos() {

        List<PlatoDTO> response = new ArrayList<>();
        List<Plato> platosDisponibles;

        platosDisponibles = platoRepository.obtenerPlatos();

        for (Plato p: platosDisponibles) {
            PlatoDTO obj = new PlatoDTO();
            obj.setName(p.getName());
            obj.setIngrendients(p.getListaIngredientes());
            response.add(obj);
        }

        return response;
    }

    @Override
    public Plato obtenerPlatoPorNombre(String platoName) {
        return null;
    }

    @Override
    public CaloriasTotalesDTO obtenerCaloriasPorGramos(PlatoPesoDTO platoPesoDto) {

        int caloriasTotales = 0;
        Plato platoIngresado = new Plato();
        CaloriasTotalesDTO response = new CaloriasTotalesDTO();
        platoIngresado = platoRepository.obtenerPlatoPorNombre(platoPesoDto.getName());

        if(platoIngresado!=null){
            caloriasTotales = platoPesoDto.getWeight() * ingredienteService.calcularCaloriasDeIngredientesPorPlato(platoIngresado);
        }

        response.setTotalCalorias(caloriasTotales);

        return response;
    }

    @Override
    public List<IngredienteDTO> obtenerIngredientesPorPlato(PlatoDTO p) {

        List<IngredienteDTO> listaIngredientes = new ArrayList<>();
        Plato plato = new Plato();
        plato = PlatoMapper.PlatoDTOToPlato(p);

        listaIngredientes = ingredienteService.obtenerIngredientesPorPlato(plato);

        return listaIngredientes;

    }

    @Override
    public IngredienteDTO obtenerIngredienteConMayorCaloria(PlatoDTO plato) {

        List<IngredienteDTO> ingredientesDelPlato = new ArrayList<>();
        Plato platoRepository = PlatoMapper.PlatoDTOToPlato(plato);
        IngredienteDTO response = new IngredienteDTO();

        ingredientesDelPlato = ingredienteService.obtenerIngredientesPorPlato(platoRepository);
        response = ingredientesDelPlato.stream()
                .collect(Collectors.groupingBy(
                        IngredienteDTO::getCalorias,
                        TreeMap::new,
                        Collectors.toList()
                )).lastEntry().getValue().get(0);

        return response;
    }
}
