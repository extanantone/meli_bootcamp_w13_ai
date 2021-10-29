package com.company;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public PracticaExcepciones() {
    }

    public void calcularCociente() {
        try{
            System.out.println(this.b/this.a);
        } catch (Exception e) {
            System.out.println("Se a producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public void calcularCociente2() {
        try{
            System.out.println(this.b/this.a);
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
