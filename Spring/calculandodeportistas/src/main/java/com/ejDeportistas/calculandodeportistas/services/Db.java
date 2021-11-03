package com.ejDeportistas.calculandodeportistas.services;

import com.ejDeportistas.calculandodeportistas.dtos.PersonaDeporteDto;
import com.ejDeportistas.calculandodeportistas.models.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
public class Db {
    private ArrayList<Persona> listaPersona = new ArrayList<>();
    private ArrayList<Deporte> listaDeporte = new ArrayList<>();
    private ArrayList<Deporte> personaDeporte = new ArrayList<>();

    public Db(){
        listaDeporte.add(new Deporte("Futbol", 3));
        listaDeporte.add(new Deporte("Basquet", 2));
        listaPersona.add(new Persona("John", "doe", 15));
        personaDeporte.add(listaDeporte.get(0));
        listaPersona.add(new Persona("Second", "dae", 30));
        personaDeporte.add(listaDeporte.get(1));
        listaPersona.add(new Persona("Third", "due", 70));
        personaDeporte.add(listaDeporte.get(1));
    }

    public Deporte searchDeporte(String name){
        for(Deporte d : listaDeporte){
           if(d.getNombre().equals(name)){
               return d;
           }
        }
        return null;
    }

    public List<PersonaDeporteDto> goRelationToDto(){
        return IntStream.range(0,listaPersona.size())
                .mapToObj((i)-> new PersonaDeporteDto(
                        listaPersona.get(i).getNombre(),
                        listaPersona.get(i).getApellido(),
                        personaDeporte.get(i).getNombre()))
                .collect(Collectors.toList());
    }

}
