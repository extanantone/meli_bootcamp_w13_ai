package com.example.bootcamp.comida.service;

import com.example.bootcamp.comida.repository.IIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService implements IIngredienteService {

    @Autowired
    private IIngredienteRepository ingredienteRepository;

    @Override
    public void obtenerIngredientes() {

    }

    public int obtenerCaloriasPorNombre(String ingredienteNombre){


        return 0;
    }

}
