package com.bootcamp.Clase3.service;


import com.bootcamp.Clase3.dto.PersonajeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService implements IPersonajeService{



    @Override
    public List<PersonajeDTO> obtenerPersonaje(String nombre) {
        return null;
    }
}
