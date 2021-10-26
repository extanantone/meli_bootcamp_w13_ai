package com.company;

public class Main {

    public static void main(String[] args){

        Persona sebastian = new Persona();
        Persona seba = new Persona("Sebastian", 123, "321");
        Persona seb = new Persona("Sebastian", 123, "321", 99, 1.80);
        // Persona fail = new Persona("Pizza", 99); Esto genera error, "No suitable constructor".
    }
}
