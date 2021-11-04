package com.c3spring.ejercicio.repository;

import com.c3spring.ejercicio.model.Personaje;

import java.util.List;

public interface IObtenerData {
    public List<Personaje> obtenerOrigenDatos(String nombre);
}
