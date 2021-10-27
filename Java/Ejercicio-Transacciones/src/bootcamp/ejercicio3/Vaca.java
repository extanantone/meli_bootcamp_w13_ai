package bootcamp.ejercicio3;

import bootcamp.ejercicio3.interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {



    @Override
    public void comerAnimal() {
        comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("Como pasto");
    }
}
