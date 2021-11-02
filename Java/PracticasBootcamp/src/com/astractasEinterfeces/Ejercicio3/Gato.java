package com.astractasEinterfeces.Ejercicio3;

public class Gato extends Animal{

    private static final String come = "Come carne";

    @Override
    public void emiteSonido() {
        System.out.println("miauuu");
    }

    @Override
    public void comerAnimel() {
        System.out.println(Gato.come);
    }
}
