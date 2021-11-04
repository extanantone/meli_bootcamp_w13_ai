package com.example.demo.service;

import com.example.demo.dto.PersonajeDTO;
import com.example.demo.models.Personaje;
import com.example.demo.repository.IRepositoryPersonaje;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary //Para que tome esta implementacion como primaria
public class PersonajeServiceImp implements IPersonajeService {
    IRepositoryPersonaje personajeRepository;


    public PersonajeServiceImp(IRepositoryPersonaje personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<PersonajeDTO> obtenerPersonajes(String nombre) {
        System.out.println("hola");
        List<Personaje> personajes = this.personajeRepository.buscarPersonajes(nombre);

        return personajes.stream().map(p -> new PersonajeDTO(p)).collect(Collectors.toList());
    }

}
