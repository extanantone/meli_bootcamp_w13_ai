package com.company.aylu;

public class Main {

    public static void main(String[] args) {
	Persona persona1 = new Persona();
    Persona persona2 = new Persona("juan",23,"450987651");
    Persona persona3 = new Persona("sofia",18,"39471379",67.8F,1.89F);


    /*
    si intentamos utilizar un constructor y no existe => va a saltar error
     Persona personaConError = new Persona("NombreError",100);
     result_message: cannot resolve constructor (String,int)
     */
        System.out.println(persona1.getNombre());
        System.out.println(persona2.getNombre());
        System.out.println(persona2.calcularIMC());
        System.out.println("PERSONA 3 - SOFIA");


    }
}
