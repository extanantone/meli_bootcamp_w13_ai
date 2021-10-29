package com.bootcamp.apiromanos.model;

public class Numero {

    private int unidades;

    private int decenas;

    private int centenas;

    private int miles;

    public Numero(int n) {
        descomponer(n);
    }

    private void descomponer(int n) {
        miles = n / 1000;
        n = n % 1000;
        centenas = n / 100;
        n = n % 100;
        decenas = n / 10;
        unidades = n % 10;
    }

    public int getUnidades() {
        return unidades;
    }

    public int getDecenas() {
        return decenas;
    }

    public int getCentenas() {
        return centenas;
    }

    public int getMiles() {
        return miles;
    }
}
