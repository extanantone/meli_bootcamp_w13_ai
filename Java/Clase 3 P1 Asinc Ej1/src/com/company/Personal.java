package com.company;

public abstract class Personal extends Persona{
    String legajo;
    String ocupacion;

    public Personal(String nombre, String dni, String legajo, String ocupacion) {
        super(nombre, dni);
        this.legajo = legajo;
        this.ocupacion = ocupacion;
    }

    abstract void fichar();
}
