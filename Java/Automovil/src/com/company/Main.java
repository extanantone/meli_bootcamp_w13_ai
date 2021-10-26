package com.company;

public class Main {

    public static void main(String[] args) {
	    Automovil automovil = new Automovil("Toyota","azul",15.5);
        System.out.println("El automovil: "+automovil.marca);
        System.out.println("Marca y Color: "+ automovil.mostrarMarcaYColor());
    }
}
