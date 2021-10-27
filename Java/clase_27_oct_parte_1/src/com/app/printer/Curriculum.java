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
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Curriculum{\npersona: "+persona.toString()+"\nhabilities: "+habilities.toString()+"\n}";
    }
    
}
