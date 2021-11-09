package com.DTO.StarWars.service;

import com.DTO.StarWars.dto.PersonajeDTO;
import com.DTO.StarWars.mapper.PersonajeMapper;
import com.DTO.StarWars.model.Personaje;
import com.DTO.StarWars.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{

    @Autowired
    IPersonajeRepository personajeRepository;


    @Override
    public List<PersonajeDTO> getPersonajeByName(String name) {
        List<Personaje> personajes = personajeRepository.findByName(name);
        return personajes.stream()
                .map(personaje -> PersonajeMapper.personajeToPersonajeDTO(personaje))
                .collect(Collectors.toList());
    }
}
