package com.c3spring.ejercicio.manana.servicio;

import com.c3spring.ejercicio.manana.dto.PersonajeDTO;

import java.util.List;

public interface IBuscable {
    public List<PersonajeDTO> encontrar(String nombre);
}
