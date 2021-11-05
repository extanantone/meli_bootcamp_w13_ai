package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.bootcamp.starwars.model.Personaje;
import com.bootcamp.starwars.repository.IPersonajeRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{

    IPersonajeRepository personajeRepository;

    public PersonajeService(IPersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<PersonajeDTO> obtenerPersonaje(String nombre) {
        List<Personaje> personajes = this.personajeRepository.
                buscarPersonajes(nombre);

        List<PersonajeDTO> personajeDTOs = personajes.stream()
                .map( p -> new PersonajeDTO(p) )
                .collect(Collectors.toList());

        return personajeDTOs;
    }
}
