package com.c3.p1.service;

import com.c3.p1.dto.PersonajeDto;
import com.c3.p1.repository.IPersonajeRepository;
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
    public List<PersonajeDto> buscarPersonaje(String name) {
        return personajeRepository.buscarPersonajes(name).stream().map(PersonajeDto::new).collect(Collectors.toList());
    }
}
