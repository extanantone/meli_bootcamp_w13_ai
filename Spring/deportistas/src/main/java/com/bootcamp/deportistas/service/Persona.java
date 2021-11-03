package com.bootcamp.deportistas.service;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Deporte> deportesQueRealiza;

    public Persona(String nombre, String apellido, Integer edad, List<Deporte> deportesQueRealiza) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deportesQueRealiza = deportesQueRealiza;
    }

    public Persona(String nombre, String apellido, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deportesQueRealiza = new ArrayList<>();
    }

    public void empezarDeporte(Deporte d){
        this.deportesQueRealiza.add(d);
    }

    public boolean esDeportista(){
        return this.deportesQueRealiza.size() > 0;
    }
}
