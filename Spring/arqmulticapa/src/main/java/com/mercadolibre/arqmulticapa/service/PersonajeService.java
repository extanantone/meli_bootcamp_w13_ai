package com.mercadolibre.arqmulticapa.service;

import com.mercadolibre.arqmulticapa.dto.PersonajeDTO;
import com.mercadolibre.arqmulticapa.model.Personaje;
import com.mercadolibre.arqmulticapa.repository.IPersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{
    IPersonajeRepository iPersonajeRepository;

    public PersonajeService(IPersonajeRepository iPersonajeRepository) {
        this.iPersonajeRepository = iPersonajeRepository;
    }

    @Override
    public List<PersonajeDTO> obtenerPersonaje(String nombre) {
        List<Personaje> personajes= this.iPersonajeRepository.buscarPersonaje(nombre);

        return personajes.stream()
                .map(PersonajeDTO::new)
                .collect(Collectors.toList());
    }
}
