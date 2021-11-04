package com.c3spring.ejercicio.manana.repository;

import com.c3spring.ejercicio.manana.model.Personaje;

import java.util.List;

public interface IObtenerData {
    public List<Personaje> obtenerOrigenDatos(String nombre);
}
