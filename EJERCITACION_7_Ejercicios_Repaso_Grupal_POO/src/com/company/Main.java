package com.company;

public class Main {

    public static void main(String[] args) {

        Persona p1 = new Persona ("Andres","445566",15,80.5,1.4);
        Persona p2 = new Persona("Juan","778855",10);
        Persona p3 = new Persona();

        System.out.println("Persona 1:");


        System.out.printf(p1.toString()+"\n");
        if (p1.calcularIMC()==1)
        {
            System.out.println("Sobrepeso");
        }
        else   {
            if (p1.calcularIMC()==0)
            {
                System.out.println("Peso saludable");
            }
            else
            {
                System.out.println("Bajo Peso");
            }
        }
        if (p1.esMayorDeEdad())
        {
            System.out.println("Es mayor de edad");
        }
        else {
            System.out.println("Es menor de edad");
        }

        /*System.out.println("\n\nPersona 2:");

        System.out.println(p2.calcularIMC());
        System.out.println(p2.esMayorDeEdad());
        System.out.printf(p2.toString());

        System.out.println("\n\nPersona 3:");

        System.out.println(p3.calcularIMC());
        System.out.println(p3.esMayorDeEdad());
        System.out.printf(p3.toString());*/
    }
}
