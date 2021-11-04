package com.example.c3_arq_mult_vivo_p1.service;

import com.example.c3_arq_mult_vivo_p1.dto.PersonajeDTO;
import com.example.c3_arq_mult_vivo_p1.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService
{
    @Autowired
    IPersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDTO> getPersonajes(String name)
    {
        return personajeRepository.buscarPersonajes(name).stream().map(PersonajeDTO::new).collect(Collectors.toList());
    }
}
