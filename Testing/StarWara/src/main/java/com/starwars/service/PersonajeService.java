package com.starwars.service;

import com.starwars.dto.PersonajeDto;
import com.starwars.model.Personaje;
import com.starwars.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{

    @Autowired
    private IPersonajeRepository repository;

    public List<PersonajeDto> getPersonajesByName(String name){
        return repository.getPersonajesByName(name).stream()
                .map(i->new PersonajeDto(i.getName(),i.getHeight(),i.getMass(),i.getGender(),i.getHomeworld(),i.getSpecies()))
                .collect(Collectors.toList());
    }
}
