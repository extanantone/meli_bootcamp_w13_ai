package com.company;

public class Main {

    public static void main(String[] args) {
        PracticaExcepciones practica = new PracticaExcepciones();

        try {
            System.out.println(practica.b / practica.a);
        } catch (ArithmeticException exception) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
