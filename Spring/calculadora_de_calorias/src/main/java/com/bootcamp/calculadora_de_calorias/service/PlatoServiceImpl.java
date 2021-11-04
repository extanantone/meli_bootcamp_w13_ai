package com.bootcamp.calculadora_de_calorias.service;

import com.bootcamp.calculadora_de_calorias.dto.IngredienteDTO;
import com.bootcamp.calculadora_de_calorias.dto.PlatoDTO;
import com.bootcamp.calculadora_de_calorias.model.Ingrediente;
import com.bootcamp.calculadora_de_calorias.repository.IIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlatoServiceImpl implements IPlatoService{

    IIngredienteRepository repository;

    @Autowired
    public PlatoServiceImpl(IIngredienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Double calcularCalorias(List<IngredienteDTO> ingredientes) {
        //List<IngredienteDTO> ingredientes = plato.getIngredientes(); //ver de pasar directamente los ingr
        Double totalCalorias = 0.0;

        List<Ingrediente> ingredientesAndCalorias = getAporteCalorias(ingredientes);
        for (Ingrediente ingr : ingredientesAndCalorias) {
            totalCalorias += ingr.getCalories();
        }

        return totalCalorias;
    }

    @Override
    public List<Ingrediente> getIngredientesAndCalorias(List<IngredienteDTO> ingredientes) {
        //List<IngredienteDTO> ingredientes = plato.getIngredientes();
        //obtengo las calorias que aporta cada ingrediente
        List<Ingrediente> ingredientesAndCalorias = getAporteCalorias(ingredientes);

        return ingredientesAndCalorias;
    }

    @Override
    public String getIngredienteMaxCalorias(List<IngredienteDTO> ingredientes) {
        //List<IngredienteDTO> ingredientes = plato.getIngredientes();
        //obtengo las calorias que aporta cada ingrediente
        List<Ingrediente> ingredientesAndCalorias = getAporteCalorias(ingredientes);
        String nombreMayor = "";
        Double caloriasMayor = -100.0;
        for (Ingrediente ingr : ingredientesAndCalorias) {
            if(ingr.getCalories() > caloriasMayor){
                caloriasMayor = ingr.getCalories();
                nombreMayor = ingr.getName();
            }
        }
        return nombreMayor;
    }

    //calcula las calorias que aporta cada ingrediente del plato
    private List<Ingrediente> getAporteCalorias(List<IngredienteDTO> ingredientes){
        //Map<String, Double> ingredienteCalorias = new HashMap<>();
        List<Ingrediente> ingredientesAndCalorias = new ArrayList<>();

        for (IngredienteDTO ingr : ingredientes) {
            ingredientesAndCalorias.add(new Ingrediente(ingr.getNombre(), repository.getCalorias(ingr.getNombre()) * ingr.getPeso() / 100));
            //ingredienteCalorias.put(ingr.getNombre(), repository.getCalorias(ingr.getNombre()) * ingr.getPeso() / 100);
        }

        return ingredientesAndCalorias;
    }
}
