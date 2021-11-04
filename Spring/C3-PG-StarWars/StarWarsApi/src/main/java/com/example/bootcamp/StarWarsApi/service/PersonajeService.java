package com.example.bootcamp.StarWarsApi.service;

import com.example.bootcamp.StarWarsApi.dto.PersonajeDTO;
import com.example.bootcamp.StarWarsApi.model.Personaje;
import com.example.bootcamp.StarWarsApi.repository.IPersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PersonajeService implements IPersonajeService{


    IPersonajeRepository personajeRepository;

    public PersonajeService(IPersonajeRepository personajeRepository){
        this.personajeRepository = personajeRepository;
    }


    @Override
    public List<PersonajeDTO> obtenerPersonajes(String nombre) {

    List<Personaje> personajes = this.personajeRepository.buscarPersonajes(nombre);


    List <PersonajeDTO> personajesDTOS = personajes.stream()
            .map(p -> new PersonajeDTO(p))
            .collect(Collectors.toList());

    return personajesDTOS;

    }
}
