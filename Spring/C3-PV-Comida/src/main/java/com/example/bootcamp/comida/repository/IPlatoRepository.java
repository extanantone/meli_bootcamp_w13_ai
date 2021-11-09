package com.example.bootcamp.comida.repository;

import com.example.bootcamp.comida.model.Plato;

import java.util.List;

public interface IPlatoRepository {

    public void guardarPlato(Plato p);

    public List<Plato> obtenerPlatos();

    public Plato obtenerPlatoPorNombre(String platoName);

}
