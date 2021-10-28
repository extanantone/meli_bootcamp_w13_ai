package com.company;

public class Main {

    public static void main(String[] args) {
        Persona Juan = new Persona();
        Persona Facundo = new Persona("Facundo", 45, "42859333");
        Persona Azul = new Persona("Azul", 23, "43758743", 60, 165);

        boolean esMayorDeEdad = Azul.esMayorDeEdad();

        int valorIMC = Azul.calcularIMC();
        String nivelDePeso;


        switch (valorIMC)
        {
            case -1: nivelDePeso = "bajo";
                break;
            case 0: nivelDePeso = "saludable";
                break;
            case 1: nivelDePeso = "alto";
                break;
            default: nivelDePeso = "desconocido";
                break;
        }
        System.out.println("Azul tiene un nivel de peso " + nivelDePeso);


        if (esMayorDeEdad) {
            System.out.println("Azul es mayor de edad");
        }
        else {
            System.out.println("Azul no es mayor de edad");
        }

        Azul.mostrarDatos();


    }


}
