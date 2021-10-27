package com.app.printer;

import java.util.List;

public class Curriculum implements Imprimible{

    private Persona persona;

    private List<String> habilities;

    public Curriculum(Persona persona,List<String> habilities){
        this.persona = persona;
        this.habilities = habilities;
    }

    @Override
    public void imprimir() {
        // TODO Auto-generated method stub
        
    }
    
}
