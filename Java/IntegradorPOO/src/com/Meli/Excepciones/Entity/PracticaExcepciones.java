package com.Meli.Excepciones.Entity;

public class PracticaExcepciones {
    private int a, b;

    public PracticaExcepciones() {
        this.a = 0;
        this.b = 300;
    }
    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }
}
