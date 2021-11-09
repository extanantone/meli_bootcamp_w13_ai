package com.example.bootcamp.comida.service;

import com.example.bootcamp.comida.dto.IngredienteDTO;
import com.example.bootcamp.comida.model.Ingrediente;
import com.example.bootcamp.comida.model.Plato;
import com.example.bootcamp.comida.repository.IIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredienteService implements IIngredienteService {

    @Autowired
    private IIngredienteRepository ingredienteRepository;

    @Override
    public void obtenerIngredientes() {

    }

    public int obtenerCaloriasPorNombreIngrediente(String ingredienteNombre){

        int calorias;
        calorias = ingredienteRepository.obtenerCaloriasPorNombreIngrediente(ingredienteNombre);
        return calorias;
    }

    @Override
    public int calcularCaloriasDeIngredientesPorPlato(Plato platoIngresado) {

        int caloriasTotalesAlimento=0;
        List<Ingrediente> ingredientesDePlato = new ArrayList<>();

        ingredientesDePlato = platoIngresado.getListaIngredientes();

        for (Ingrediente i: ingredientesDePlato) {
            caloriasTotalesAlimento += obtenerCaloriasPorNombreIngrediente(i.getName());
        }

        return caloriasTotalesAlimento;

    }

    @Override
    public List<IngredienteDTO> obtenerIngredientesPorPlato(Plato p) {

        List<IngredienteDTO> listaIngredientes = new ArrayList<>();
        List<Ingrediente> ingredientesPlato = p.getListaIngredientes();

        for (Ingrediente i: ingredientesPlato) {
            int calorias = 0;
            IngredienteDTO ingredientes = new IngredienteDTO();
            calorias = ingredienteRepository.obtenerCaloriasPorNombreIngrediente(i.getName());
            ingredientes.setNombreIngrediente(i.getName());
            ingredientes.setCalorias(calorias);

            listaIngredientes.add(ingredientes);
        }

        return listaIngredientes;
    }

}
