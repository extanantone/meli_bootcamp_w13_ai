package com.bootcamp.general;

import com.bootcamp.models.Persona;

public class Main {

    //Ejercicio 3
    public static void main(String [] args){


    //Ejercicio 4

    Persona pablo = new Persona ();
    Persona matias = new Persona ("Matias",24,"3322332233");
    Persona elias = new Persona ("Elias","3322332233",24, 1.84, 70.5);

    //En este caso, al pasarlo, generara un error porque no existe un constructor que acepte estos dos parametros.
    //Persona jorgelina = new Persona ("Jorgelina",25);

        elias.toString();
    procesarImcObtenido(elias.calcularIMC());
    informarSiEsMayorDeEdad(elias.esMayorDeEdad());

    }


    private static void procesarImcObtenido(int valor){

        if(valor == -1){
            System.out.println("El usuario presenta un bajo peso, por debajo de 20.");
        }
        else if(valor == 0){
            System.out.println( "El usuario presenta un peso saludable, el IMC esta entre los 20 y 25");
        }
        else
            System.out.println( "El usuario presenta sobrepeso, el IMC es mayor a 25");

    }

    private static void informarSiEsMayorDeEdad(boolean esMayorDeEdad){

        if(esMayorDeEdad)
            System.out.println("La persona es mayor de edad");
        else
            System.out.println("La persona es menor de edad");

    }



}
