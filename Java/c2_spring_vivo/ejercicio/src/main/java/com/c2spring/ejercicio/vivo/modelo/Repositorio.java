package com.c2spring.ejercicio.vivo.modelo;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Repositorio {
    private static List<Persona> listaPersonas = new ArrayList<>();
    private static List<Deporte> listaDeportes = new ArrayList<>();

    static{
        listaDeportes.addAll(List.of(new Deporte("futbol",1),new Deporte("tenis",2), new Deporte("natacion",3)));
        listaPersonas.addAll(List.of(new Persona(21,"Memo","Perez",listaDeportes.get(0)),
                new Persona(27,"Gustavo","Molina",listaDeportes.get(2))));
    }

    public static List<Deporte> showDeportes(){
        return listaDeportes;
    }
    public static List<Persona> showPersonas(){
        return listaPersonas;
    }

    public void addPersona(Persona persona){listaPersonas.add(persona);}
    public void addDeporte(Deporte deporte){listaDeportes.add(deporte);}

    public static Deporte findDeporte(String nombre){
        List<Deporte> lista = listaDeportes.stream().filter(x->x.getNombre().equals(nombre)).collect(Collectors.toList());
        if(lista.isEmpty())
        {
            return null;
        }
        else
            return lista.get(0);
    }



}
