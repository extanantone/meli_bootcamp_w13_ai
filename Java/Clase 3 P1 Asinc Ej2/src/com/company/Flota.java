package com.company;

import java.util.ArrayList;
import java.util.List;

public class Flota implements Rastreable {
    List<Nave> naves;
    String nombre;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Flota() {
        this.naves = new ArrayList<>();
    }

    public void agregarNave(Nave nave){
        naves.add(nave);
    }

    @Override
    public double CalcularCercania(double x, double y) {
        double cercaniaAcumulada = 0;
        for(Nave nave : naves){
            cercaniaAcumulada += nave.CalcularCercania(x, y);
        }
        return cercaniaAcumulada / (double)naves.size();
    }
}
