package com.bootcamp.apistarwars.service;

import com.bootcamp.apistarwars.dto.PersonajeDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPersonajeService {

    List<PersonajeDTO> obtenerPersonaje(String nombre);

}
