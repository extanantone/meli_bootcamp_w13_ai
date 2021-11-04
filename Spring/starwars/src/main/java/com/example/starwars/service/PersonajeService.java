package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.model.Personaje;
import com.example.starwars.repository.IPersonajeRepository;
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
