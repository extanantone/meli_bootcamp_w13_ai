package com.MELI;

import com.MELI.models.Persona;

public class Main {

    public static void main(String[] args) {

        Persona sofia = new Persona("Sofia", 30, "36327762", 1.58, 53.0);
        Persona olivia = new Persona("Olivia", 5, "435845435", 1.15, 14.0);
        Persona santino = new Persona("Santino", 12, "423422546", 1.68, 65.0);

        //Este constructor no existe en la clase persona. Tira un error diciendo que no existe, y te ofrece crearlo si lo deseas.
        //Persona olivia = new Persona("Olivia", 30);

        //EJERCICIO 6
        int imc = sofia.calcularIMC();
        if (imc == 1) {
            System.out.println("Usted tiene \'Sobrepeso\', con gusto le indicaremos una dieta para mejorar su salud");
        } else if (imc == 0) {
            System.out.println("Usted se encuentra \'Saludable\', Felicitaciones!");
        } else {
            System.out.println("Usted tiene \'Bajo Peso\', con gusto le indicaremos una dieta para mejorar su salud");
        }

        boolean mayorDeEdad = sofia.esMayorDeEdad();
        if (mayorDeEdad) {
            System.out.println("La persona es mayor de edad");
        } else {
            System.out.println("La persona es menor de edad");
        }
    }
}
