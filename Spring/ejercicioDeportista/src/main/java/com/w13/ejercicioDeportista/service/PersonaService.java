package com.w13.ejercicioDeportista.service;

import com.w13.ejercicioDeportista.dto.PersonaDto;
import com.w13.ejercicioDeportista.entity.Deporte;
import com.w13.ejercicioDeportista.entity.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaService {

//      personas.add(new Persona("Leonel", "Messi", 34));
//        personas.add(new Persona("Juan", "Klutz", 34));
//        personas.add(new Persona("Karen", "Saber", 34));
//        personas.add(new Persona("Maga", "Guerra", 34));

    Persona persona = new Persona("Leonel", "Messi", 34);
    Persona persona1 = new Persona("Juan", "Klutz", 24);
    PersonaDto personaDto = new PersonaDto();
    PersonaDto personaDto1 = new PersonaDto();
    Deporte deporte = new Deporte("Futbol", "Intermedio");
    Deporte deporte1 = new Deporte("Tenis", "Principiante");

    public List<PersonaDto> cargaPersonDto() {
        List<PersonaDto> personaDtos = new ArrayList<>();
        personaDto.setNombre(persona.getNombre());
        personaDto.setApellido(persona.getApellido());
        personaDto.cargaDeporteList(deporte);
        personaDtos.add(personaDto);

        personaDto1.setNombre(persona1.getNombre());
        personaDto1.setApellido(persona1.getApellido());
        personaDto1.cargaDeporteList(deporte1);
        personaDtos.add(personaDto1);

        return personaDtos;

    }
}
