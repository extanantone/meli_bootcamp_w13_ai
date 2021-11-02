package com.astractasEinterfeces.Ejercicio3;

public class Main {
    public static void main(String[] args) {

        Animal gato = new Gato();
        Animal perro = new Perro();
        Animal vac  = new Vaca();

        gato.emiteSonido();
        perro.emiteSonido();
        vac.emiteSonido();

        gato.comerAnimel();
        perro.comerAnimel();
        vac.comerAnimel();
    }
}
