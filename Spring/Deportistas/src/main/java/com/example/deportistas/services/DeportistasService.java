package com.example.deportistas.services;

import com.example.deportistas.dto.PersonasDeporteDTO;
import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class DeportistasService {

    private List<Deporte> deportes = new ArrayList<>();

    private List<Persona> personas = new ArrayList<>();

    public DeportistasService() {
        this.deportes.add(new Deporte(1L,"Futbol",1));
        this.deportes.add(new Deporte(2L,"Beisbol",1));
        this.deportes.add(new Deporte(3L,"Basquet",1));
        this.deportes.add(new Deporte(4L,"Tenis",2));
        this.deportes.add(new Deporte(5L,"Americano",2));
        this.personas.add(new Persona(1L,"Juan1","Lozano1",23,this.deportes.get(4)));
        this.personas.add(new Persona(2L,"Juan2","Lozano2",23,this.deportes.get(3)));
        this.personas.add(new Persona(3L,"Juan3","Lozano3",23,this.deportes.get(2)));
        this.personas.add(new Persona(4L,"Juan4","Lozano4",23,this.deportes.get(1)));
        this.personas.add(new Persona(5L,"Juan5","Lozano5",23,this.deportes.get(0)));
        this.personas.add(new Persona(6L,"Juan6","Lozano6",23,this.deportes.get(2)));
        this.personas.add(new Persona(7L,"Juan7","Lozano7",23,this.deportes.get(4)));
        this.personas.add(new Persona(8L,"Juan8","Lozano8",23,this.deportes.get(4)));
        this.personas.add(new Persona(9L,"Juan9","Lozano9",23,this.deportes.get(4)));
        this.personas.add(new Persona(10L,"Juan10","Lozano10",23,this.deportes.get(1)));
        this.personas.add(new Persona(11L,"Juan11","Lozano11",23,this.deportes.get(1)));

    }

    public List<Deporte> encontrarDeportes(){
        return this.deportes;
    }

    public Deporte encontrarDeporte(String name){
        return this.deportes.stream()
                .filter(x -> x.getNombre().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<PersonasDeporteDTO> encontrarPersonasDeporte(){
        List<PersonasDeporteDTO> result = new ArrayList<>();
        this.personas.stream().forEach(x -> result.add(new PersonasDeporteDTO(x.getNombre(),x.getApellido(),x.getDeporte().getNombre())));
        return result;
    }
}
