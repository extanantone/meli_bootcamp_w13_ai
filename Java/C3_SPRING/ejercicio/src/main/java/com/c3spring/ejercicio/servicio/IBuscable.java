package com.c3spring.ejercicio.servicio;

import com.c3spring.ejercicio.dto.PersonajeDTO;

import java.util.List;

public interface IBuscable {
    public List<PersonajeDTO> encontrar(String nombre);
}
