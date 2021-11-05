package com.example.ejercicio_deportistas.Servicios;

import com.example.ejercicio_deportistas.Modelos.Deporte;
import com.example.ejercicio_deportistas.Modelos.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonaServicio {
    static List<Persona> personasList = new ArrayList<Persona>();

    public List<Persona> getDeportistas(){
        return personasList.stream().filter(p -> p.getDeporte() != null).collect(Collectors.toList());
    }

    public void setPersona(Persona persona) {
        this.personasList.add(persona);
    }
}
