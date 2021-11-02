package com.astractasEinterfeces.Ejercicio3;

public class Vaca extends Animal{

    private  static final String come = "pasto";
    @Override
    public void emiteSonido() {
        System.out.println("muuuu");
    }

    @Override
    public void comerAnimel() {
        System.out.println("Come "+Vaca.come);
    }
}
