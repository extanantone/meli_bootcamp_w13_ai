package com.company;

import jdk.swing.interop.SwingInterOpUtils;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 24, "40111222");
        Persona persona3 = new Persona("Juan", 24, "40111222", 73.0, 1.75);
        // Persona persona4 = new Persona("Juan", 24);

        System.out.println(persona3.toString());
        System.out.println("Resultado IMC: " + persona3.calcularIMC());
        if (persona3.calcularIMC() == -1) {
            System.out.println("Bajo peso");
        } else if (persona3.calcularIMC() == 0) {
            System.out.println("Peso saludable");
        } else if (persona3.calcularIMC() == 1) {
            System.out.println("Sobrepeso");
        } else {
            System.out.println("Error en calculo de IMC");
        }
        System.out.println("Es mayor de edad: " + persona3.esMayorDeEdad());
    }
}
