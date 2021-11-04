package com.mercadolibre.arqmulticapa.service;

import com.mercadolibre.arqmulticapa.dto.PersonajeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> obtenerPersonaje(String nombre);
}
