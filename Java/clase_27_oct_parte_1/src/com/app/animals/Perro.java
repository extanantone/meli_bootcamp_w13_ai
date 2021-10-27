package com.app.animals;

import com.app.animals.categories.Carnivoro;

public class Perro extends Animal implements Carnivoro{

    public Perro(){

    }

    @Override
    public String emitirSonido() {
        // TODO Auto-generated method stub
        return "guau";
    }

    @Override
    public void comerCarne() {
        // TODO Auto-generated method stub
        
    }
    
}
