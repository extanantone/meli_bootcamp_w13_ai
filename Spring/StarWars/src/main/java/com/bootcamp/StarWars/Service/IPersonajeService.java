package com.bootcamp.StarWars.Service;

import com.bootcamp.StarWars.DTO.PersonajeDTO;


import java.util.List;


public interface IPersonajeService {
    List<PersonajeDTO> obtenerPersonaje(String nombre);
}
