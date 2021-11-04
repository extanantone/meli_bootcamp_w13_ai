package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.bootcamp.starwars.model.Personaje;
import com.bootcamp.starwars.repository.IPersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements IPersonajeService{

    IPersonajeRepository personajeRepository;

    public PersonajeServiceImpl(IPersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<PersonajeDTO> obtenerPersonajes(String nombre) {
        List<Personaje> personajes = this.personajeRepository.buscarPersonajes(nombre);

        //se transforma de lista de Personaje a lista de PersonajeDTO
        return personajes.stream().map(p -> new PersonajeDTO(p)).collect(Collectors.toList());
    }
}
