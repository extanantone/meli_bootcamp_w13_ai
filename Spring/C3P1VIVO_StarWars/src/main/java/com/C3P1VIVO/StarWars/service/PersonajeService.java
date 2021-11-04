package com.C3P1VIVO.StarWars.service;

import com.C3P1VIVO.StarWars.dto.PersonajeDTO;
import com.C3P1VIVO.StarWars.model.Personaje;
import com.C3P1VIVO.StarWars.repository.IPersonajeRepository;
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
        List<Personaje> personajes = this.personajeRepository.buscarPersonajes(nombre);
        return personajes.stream()
                .map(p -> new PersonajeDTO(p))
                .collect(Collectors.toList());
    }
}
