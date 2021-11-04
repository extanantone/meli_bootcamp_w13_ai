package com.example.bootcamp.comida.service;

import com.example.bootcamp.comida.dto.PlatoDTO;
import com.example.bootcamp.comida.repository.IPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlatoService implements IPlatoService{

    @Autowired
    private IPlatoRepository platoRepository;
    @Autowired
    private IIngredienteService ingredienteService;


    @Override
    public void crearPlato(PlatoDTO p) {



    }
}
