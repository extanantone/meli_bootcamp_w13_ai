package com.company;

public class Vaca extends Animal implements Herviboro{

    @Override
    void emitirSonido() {
        System.out.println("tomaaaaco tomaaaaco");
    }

    @Override
    void comer() {
        comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca esta comiendo pastito");
    }
}
