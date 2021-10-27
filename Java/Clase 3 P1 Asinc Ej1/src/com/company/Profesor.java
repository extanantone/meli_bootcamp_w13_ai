package com.company;

public class Profesor extends Personal implements Enseñante{

    public Profesor(String nombre, String dni, String legajo, String ocupacion) {
        super(nombre, dni, legajo, ocupacion);
    }

    @Override
    public void Explicar() {
        System.out.println("El profesor está explicando");
    }

    @Override
    public void PreguntarDudas() {
        System.out.println("El profesor está preguntando si hay alguna duda");
    }

    @Override
    void fichar() {
        System.out.println("El profesor está fichando");
    }
}
