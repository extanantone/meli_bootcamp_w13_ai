package com.astractasEinterfeces.Ejercicio3;

public class Perro extends Animal{

    private static final String come = "Come carne";

    @Override
    public void emiteSonido() {
        System.out.println("guau guau");
    }

    @Override
    public void comerAnimel() {
        System.out.println("Come :"+Perro.come);
    }
}
