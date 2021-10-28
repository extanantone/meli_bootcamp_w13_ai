package com.company;

public abstract class Prenda {
    String marca;
    String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public abstract String toString();
}
