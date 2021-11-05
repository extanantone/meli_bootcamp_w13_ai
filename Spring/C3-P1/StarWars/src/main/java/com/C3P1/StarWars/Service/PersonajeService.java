package com.C3P1.StarWars.Service;

import com.C3P1.StarWars.DTO.PersonajeDTO;
import com.C3P1.StarWars.Model.Personaje;
import com.C3P1.StarWars.Repository.IPersonajeRepository;
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
