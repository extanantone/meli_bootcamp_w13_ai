package com.company;

public class Gato extends Animal implements Carnivoro{
    @Override
    void emitirSonido() {
        System.out.println("miaaau miaaaaau");
    }

    @Override
    void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato esta comiendo un raton");
    }
}
