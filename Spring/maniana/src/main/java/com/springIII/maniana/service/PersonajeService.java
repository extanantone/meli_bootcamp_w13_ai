package com.springIII.maniana.service;


import com.springIII.maniana.dto.PersonajeDTO;
import com.springIII.maniana.model.Personaje;
import com.springIII.maniana.repository.IPersonajeRepository;
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
    public List<PersonajeDTO> obtenerPersonajes(String nombre) {
        List<Personaje> personajes = this.personajeRepository.
                buscarPersonajes(nombre);

        return personajes.stream()
                .map( p -> new PersonajeDTO(p) )
                .collect(Collectors.toList());
    }
}
