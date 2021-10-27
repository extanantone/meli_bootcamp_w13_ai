package com.company;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    String nombre;
    List<String> habilidades;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.habilidades = new ArrayList<>();
    }

    public void agregarHabilidad(String habilidad){
        habilidades.add(habilidad);
    }

    public void borrarHabilidad(String habilidad){
        habilidades.remove(habilidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
