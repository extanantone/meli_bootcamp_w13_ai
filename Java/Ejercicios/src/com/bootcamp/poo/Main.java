package com.bootcamp.poo;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona juan = new Persona("Juan", 26, "39.256.980");
        Persona pedro = new Persona("Pedro", 22, "40.520.156", 78.6, 170.5);
//        Persona felipe = new Persona("Felipe", 20);

        String resultadoIMC = "";

        switch (pedro.calcularIMC()) {
            case -1:
                resultadoIMC = "Lamentamos informarle que su peso se encuentra por debajo de lo deseado.";
                break;
            case 0:
                resultadoIMC = "¡Felicitaciones! Nos complace informarle que posee un peso saludable.";
                break;
            case 1:
                resultadoIMC = "Lamentamos informarle que su peso se encuentra por encima de lo esperado.";
                break;
        }

        System.out.println(resultadoIMC);
        System.out.println();

        if (pedro.esMayorDeEdad()) {
            System.out.println("Alcanzó la mayoría de edad.");
        } else {
            System.out.println("Todavía no alcanzó la mayoría de edad.");
        }

        System.out.println();
        System.out.println(pedro);
    }
}