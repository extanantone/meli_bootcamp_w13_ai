package com.mercadolibre;

public class Main {

    public static void main(String[] args) {
        Person voidPerson = new Person();
        Person basicPerson = new Person("Juana", 32, "1234");
        Person fullPerson = new Person("Juan", 25, "4356", 72.0, 1.75);

        System.out.println(fullPerson.toString());

        if (fullPerson.isAdult()) {
            System.out.println("Es mayor de edad.");
        } else {
            System.out.println("Es menor de edad.");
        }

        if (fullPerson.calculateBMI() == -1) {
            System.out.println("Bajo peso.");
        } else if (fullPerson.calculateBMI() == 0) {
            System.out.println("Peso normal.");
        } else if (fullPerson.calculateBMI() == 1) {
            System.out.println("Sobrepeso.");
        }
    }
}
