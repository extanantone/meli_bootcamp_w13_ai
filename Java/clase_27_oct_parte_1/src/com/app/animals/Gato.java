package com.app.animals;

import com.app.animals.categories.Carnivoro;

public class Gato extends Animal implements Carnivoro{

    public Gato(){
        
    }

    @Override
    public String emitirSonido() {
        // TODO Auto-generated method stub
        return "miau";
    }
    
}
