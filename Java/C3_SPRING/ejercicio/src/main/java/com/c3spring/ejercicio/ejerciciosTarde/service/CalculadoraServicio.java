package com.c3spring.ejercicio.ejerciciosTarde.service;

import com.c3spring.ejercicio.ejerciciosTarde.Repository.IRepositorio;
import com.c3spring.ejercicio.ejerciciosTarde.dto.IngredienteDTO;
import com.c3spring.ejercicio.ejerciciosTarde.dto.PlatoInDTO;
import com.c3spring.ejercicio.ejerciciosTarde.dto.PlatoOutDTO;
import com.c3spring.ejercicio.ejerciciosTarde.model.Ingrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CalculadoraServicio {

    private static final String NO_ENCONTRADO = "NO_ENCONTRADO";
    @Autowired
    IRepositorio repo;

    public PlatoOutDTO calcularDatos(PlatoInDTO platoEntrada){

        List<IngredienteDTO> listaCalculados = calcularCalsIngredientes(platoEntrada);
        double totalCalorias = calcularTotalCalorias(listaCalculados);
        String mayorCalorias = mayorCalorias(listaCalculados);

        return new PlatoOutDTO(platoEntrada.getNombre(),totalCalorias,mayorCalorias,listaCalculados);
    }

    private Double calcularTotalCalorias(List<IngredienteDTO> listaCalculados) {
        return listaCalculados.stream().mapToDouble(IngredienteDTO::getCalorias).sum();
    }

    private List<IngredienteDTO> calcularCalsIngredientes(PlatoInDTO platoEntrada) {
        List<IngredienteDTO> salida = new ArrayList<>();
        for(IngredienteDTO ingreIn:platoEntrada.getIngredientes())
        {
            Double caloriasIngrediente = repo.obtenerLista().stream()
                    .filter(x->x.getName().equals(ingreIn.getNombre()))
                    .findFirst().orElse(new Ingrediente("no valor",(double)0)).getCalories()/100;

           salida.add(new IngredienteDTO(  ingreIn.getPeso(),
                                            (caloriasIngrediente==0)?ingreIn.getNombre().concat(" " + NO_ENCONTRADO):ingreIn.getNombre(),
                                    caloriasIngrediente*ingreIn.getPeso()));
        }
        return salida;
    }

    private String mayorCalorias(List<IngredienteDTO> listaCalculados) {
        IngredienteDTO salida = listaCalculados.stream().max(Comparator.comparingDouble(IngredienteDTO::getCalorias)).orElse(null);
        if(salida.getNombre().contains(NO_ENCONTRADO))
            return NO_ENCONTRADO;
        else
            return salida.getNombre();
    }


    public List<PlatoOutDTO> calcularDatosMasivo(List<PlatoInDTO> platosIn) {
        List<PlatoOutDTO> salida = new ArrayList<>();
        for (PlatoInDTO plato : platosIn) {
            salida.add(calcularDatos(plato));
        }
        return salida;
    }

}
