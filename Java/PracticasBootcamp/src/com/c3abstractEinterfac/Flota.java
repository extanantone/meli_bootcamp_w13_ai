package com.c3abstractEinterfac;

import java.util.ArrayList;
import java.util.List;

public class Flota implements Icordenadas{

    private String nombre;
    private List<Icordenadas> flota= new ArrayList<>();

    public Flota(String nombre) {
        this.nombre = nombre;
    }

    public void agregarNaveSimple(Icordenadas icor){
        if(!flota.contains(icor)){
            flota.add(icor);
        }
    }

    @Override
    public Integer puntos() {
        return null;
    }

    @Override
    public String nombre() {
        return this.nombre;
    }

    @Override
    public void print() {
        System.out.println("Flota: "+this.nombre);
        for (Icordenadas cor: flota) {
            System.out.println("Nave:"+cor.nombre());

        }

    }

}
