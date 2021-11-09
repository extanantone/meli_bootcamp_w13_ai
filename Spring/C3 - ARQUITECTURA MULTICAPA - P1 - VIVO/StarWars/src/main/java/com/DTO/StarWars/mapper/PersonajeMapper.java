package com.DTO.StarWars.mapper;

import com.DTO.StarWars.dto.PersonajeDTO;
import com.DTO.StarWars.model.Personaje;

import java.util.List;

public class PersonajeMapper {
    public static Personaje personajeDTOToPersonaje(PersonajeDTO personajeDTO){
        Personaje personaje = new Personaje();
        personaje.setName(personajeDTO.getName());
        personaje.setHeight(personajeDTO.getHeight());
        personaje.setMass(personajeDTO.getMass());
        personaje.setGender(personajeDTO.getGender());
        personaje.setHomeworld(personajeDTO.getHomeworld());
        personaje.setSpecies(personajeDTO.getSpecies());

        return personaje;
    }

    public static PersonajeDTO personajeToPersonajeDTO(Personaje personaje){
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setName(personaje.getName());
        personajeDTO.setHeight(personaje.getHeight());
        personajeDTO.setMass(personaje.getMass());
        personajeDTO.setGender(personaje.getGender());
        personajeDTO.setHomeworld(personaje.getHomeworld());
        personajeDTO.setSpecies(personaje.getSpecies());
        return personajeDTO;
    }
}
