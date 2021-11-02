package com.c3abstractEinterfac;

import java.util.ArrayList;
import java.util.List;

public class Persona implements Icordenadas{

    private String nombre;
    //private String documentoIdentidad;
    //private String;
    private List<Icordenadas> icordenadas = new ArrayList<>();

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public void agregarNaveSimpleOflota(Icordenadas icor){
        if(!icordenadas.contains(icor)){
            icordenadas.add(icor);
        }
    }

    @Override
    public Integer puntos() {
        return 0;
    }

    @Override
    public String nombre() {
        return "";
    }

    @Override
    public void print() {

    }
}
