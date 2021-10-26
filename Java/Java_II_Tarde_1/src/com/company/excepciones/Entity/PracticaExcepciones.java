package com.company.excepciones.Entity;

public class PracticaExcepciones {
    int a = 0,b = 300;



    public void calcularDivision() {
        double tmp = 0;

        try {
           tmp = (a/b);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede divir por 0");
        }

    }
}
