package com.c2.p2vivo.services;

import com.c2.p2vivo.models.Deporte;
import com.c2.p2vivo.models.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class queryService {
    static List<Persona> personasList;
    static List<Deporte> deportesList;

    public queryService(){
        deportesList = new ArrayList<>();
        deportesList.add(new Deporte("Futbol", "Amateur"));
        deportesList.add(new Deporte("Voley", "Profesional"));
        deportesList.add(new Deporte("Ciclismo", "Semi-profesional"));

        personasList = new ArrayList<>();
        personasList.add(new Persona("Pedro", "Gonzalez", 34, deportesList.get(0)));
        personasList.add(new Persona("Juan", "Perez", 32, deportesList.get(1)));
        personasList.add(new Persona("Miriam", "Gimenez", 46, deportesList.get(2)));
        personasList.add(new Persona("Paula", "Ramirez", 21, null));

    }

    public List<Deporte> getDeportesList() {
        return deportesList;
    }

    public String getNivelDeporte(String name){
        return deportesList.stream().filter(d -> d.getNombre().equals(name)).map(Deporte::getNivel).findFirst().orElse(null);
    }

    public List<Persona> getDeportistas(){
        return personasList.stream().filter(p -> p.getDeporte() != null).collect(Collectors.toList());
    }

}
