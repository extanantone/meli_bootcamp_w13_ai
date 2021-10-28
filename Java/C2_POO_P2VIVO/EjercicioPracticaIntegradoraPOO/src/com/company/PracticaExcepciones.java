package com.company;

public class PracticaExcepciones {
    int a ;
    int b ;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void calcularCociente(){
        try {
            double cociente = 0;
            if (a == 0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            } else {
                 cociente = b/a;
            }

            System.out.println("El cocinete es: "+cociente);
        } catch (IllegalArgumentException e){
            System.out.println("Se ha producido un error: "+e.getMessage());
        }finally {
            System.out.println("Programa finalizado");
        }

    }
}
