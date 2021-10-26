package com.company;

import com.company.entity.Persona;

public class Main {

    public static void main(String[] args) {
        Persona laura = new Persona();
        Persona vanesa = new Persona("Vanesa", 30, "36220711");
        Persona martin = new Persona("Martin", 30, "35894068", 1.7f, 90);

        //Persona personaB = new Persona("Vanesa", 30); Se rompe porque no existe un constructor
        System.out.println("Datos de Martin:\n");
        System.out.println(martin.toString());
        if(martin.esMayorDeEdad())
            System.out.println("Martin es mayor de Edad");
        else
            System.out.println("Martin es menor de Edad");
        String nivel = "";
        switch (martin.cacularIMC()){
            case -1: nivel="IMC: Por debajo de 20 - Nivel de peso: Bajo Peso.";
                 break;
            case 0: nivel="IMC: Entre 20 y 25 inclusive - Nivel de peso: Peso saludable.";
                break;
            case 1: nivel="IMC: Mayor de 25 - Nivel de peso: Sobrepeso.";
                break;
            default: nivel="Datos Insuficientes para realizar calculo de IMC.";
                break;
        }
        System.out.println(nivel);

    }
}
