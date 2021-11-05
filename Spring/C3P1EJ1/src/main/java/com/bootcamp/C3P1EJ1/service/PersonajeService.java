package com.bootcamp.C3P1EJ1.service;

import com.bootcamp.C3P1EJ1.dto.PersonajeDTO;
import com.bootcamp.C3P1EJ1.model.Personaje;
import com.bootcamp.C3P1EJ1.repository.PersonajeRepositoryInterfaz;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements PersonajeServiceInterfaz {
  PersonajeRepositoryInterfaz personajeRepository;

    public PersonajeService(PersonajeRepositoryInterfaz personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<PersonajeDTO> obtenerPersonaje(String name) {
        List<Personaje> personajes = this.personajeRepository.buscarPersonajes(name);
        List<PersonajeDTO> personajeDTOS =  personajes.stream().map(personaje -> new PersonajeDTO(personaje)).collect(Collectors.toList());
        return personajeDTOS;
    }
}
