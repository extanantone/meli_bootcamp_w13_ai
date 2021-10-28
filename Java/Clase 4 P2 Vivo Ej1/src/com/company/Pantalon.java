package com.company;

public class Pantalon extends Prenda {

    public Pantalon(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public String toString() {
        return "Pantalon de marca : " + marca + " / modelo : " + modelo;
    }
}
