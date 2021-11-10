package com.company;

public class Main {

    public static void main(String[] args) {

       PracticaExcepciones p= new PracticaExcepciones();

       try {
           System.out.println(p.calcularCociente());
       }
       catch (IllegalArgumentException e){
           System.out.println(e.getMessage());
       }
       finally {
           System.out.println("Programa finalizado");
       }

    }
}
