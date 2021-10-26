package com.company;

public class PracticaExcepciones {

    private int a=0,b=300;

    public double calcularCociente(){


            if(a==0)
            {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            else
            {
                return b/a;
            }

    }

    public int getDivisor() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
