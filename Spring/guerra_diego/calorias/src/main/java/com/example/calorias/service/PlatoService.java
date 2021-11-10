package com.example.calorias.service;

import com.example.calorias.dto.IngredienteDto;
import com.example.calorias.dto.PlatoDto;
import com.example.calorias.model.Ingrediente;
import com.example.calorias.repository.IPlatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoService implements IPlatoService{

    IPlatoRepository platoRepository;

    public PlatoService(IPlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    @Override
    public double calcularCalorias(PlatoDto plato) {
        double calorias = 0D;


        for (IngredienteDto ingrediente : plato.getIngredientes()) {
            Ingrediente ingredienteNuevo = platoRepository.buscarIngredientes(ingrediente.getNombre());
            System.out.println("nn "+ingredienteNuevo.getName()+" cal "+ingredienteNuevo.getCalories());
            System.out.println("Cal "+calorias);
            calorias = calorias + (Float.valueOf(ingrediente.getPeso()) * Float.valueOf(ingredienteNuevo.getCalories())) / 100;
            System.out.println("Cal "+calorias);

            //ingredientes.add(platoRepository.buscarIngredientes(ingredienteNuevo));
        }
        /*int caloriasTotal = 0;
        List<Ingredientes> ing = platoRepository.buscarIngredientes(ingredientes);
        for (Ingredientes i: ing ) {
            caloriasTotal += i.getCalories();
            System.out.println("in "+i.getName());
        }
        return caloriasTotal;*/
        return calorias;
    }
}
