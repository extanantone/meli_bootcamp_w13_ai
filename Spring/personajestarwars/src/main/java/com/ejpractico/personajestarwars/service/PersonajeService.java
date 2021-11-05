package com.ejpractico.personajestarwars.service;

import com.ejpractico.personajestarwars.dto.PersonajeDTO;
import com.ejpractico.personajestarwars.model.Personaje;
import com.ejpractico.personajestarwars.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
                .map(PersonajeDTO::new)
                .collect(Collectors.toList());
    }
}
