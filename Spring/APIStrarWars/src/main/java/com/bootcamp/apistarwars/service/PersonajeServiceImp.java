package com.bootcamp.apistarwars.service;

import com.bootcamp.apistarwars.dto.PersonajeDTO;
import com.bootcamp.apistarwars.entity.Personaje;
import com.bootcamp.apistarwars.repository.IPersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PersonajeServiceImp implements IPersonajeService{

    IPersonajeRepository personajeRepository;

    public PersonajeServiceImp(IPersonajeRepository personajeRepository) {
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
