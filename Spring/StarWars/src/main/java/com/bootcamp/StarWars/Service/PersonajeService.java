package com.bootcamp.StarWars.Service;

import com.bootcamp.StarWars.DTO.PersonajeDTO;
import com.bootcamp.StarWars.Model.Personaje;
import com.bootcamp.StarWars.Repository.IPersonajeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements  IPersonajeService{
    IPersonajeRepository personajeRepository;

    public PersonajeService(IPersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<PersonajeDTO> obtenerPersonaje(String nombre) {
        List<Personaje> personajes =this.personajeRepository.buscarPersonajes(nombre);
        return personajes.stream().map(PersonajeDTO::new).collect(Collectors.toList());
    }
}
