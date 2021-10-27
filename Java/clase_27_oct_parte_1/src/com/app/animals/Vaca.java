package com.app.animals;

import com.app.animals.categories.Herviboro;

public class Vaca extends Animal implements Herviboro{

    public Vaca(){

    }

    @Override
    public String emitirSonido() {
        // TODO Auto-generated method stub
        return "muuuu";
    }

    @Override
    public void comerHierba() {
        // TODO Auto-generated method stub
        
    }
    
}
