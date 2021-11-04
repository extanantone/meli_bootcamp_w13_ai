package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDto;
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

    public List<PersonajeDto> obtenerPersonaje(String nombre) {
        List<Personaje> personajes = this.personajeRepository.buscarPersonaje(nombre);
        List<PersonajeDto> personajeDtos = personajes.stream().map(p -> new PersonajeDto(p)).collect(Collectors.toList());
        return personajeDtos;
    }
}
