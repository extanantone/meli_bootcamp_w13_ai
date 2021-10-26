package com.bootcamp.general;

import com.bootcamp.models.Persona;

import java.util.HashMap;

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


    //Segunda opcion interesante pasada por un compañero, utilizando un diccionario:

        HashMap<Integer,String> resultadoIMC = new HashMap<>();
        resultadoIMC.put(-1,"bajo peso");
        resultadoIMC.put(0,"peso saludable");
        resultadoIMC.put(1,"sobrepeso");
        System.out.println("Hola "+elias.getNombre()+" usted es"+(elias.esMayorDeEdad()?" mayor ":" menor ")+"de edad y teniendo en cuenta su IMC, usted tiene "+resultadoIMC.get(elias.calcularIMC()));


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
