package com.company;

public class Perro extends Animal implements Carnivoro{
    @Override
    void emitirSonido() {
        System.out.println("guau guau guau arrrgh");
    }

    @Override
    void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro está comiendo asadito");
    }
}
