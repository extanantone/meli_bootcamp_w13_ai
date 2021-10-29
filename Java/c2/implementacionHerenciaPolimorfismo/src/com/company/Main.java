package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Animal perro = new Perro("Perro", "Benja");
        perro.mostrarEspecie();
        perro.hacerSonido();

        Gato gato = new Gato("Gato", "Gardfield");
        gato.mostrarEspecie();
        gato.hacerSonido();

        Animal animal = perro;
        animal.mostrarEspecie();
        animal.hacerSonido();
    }
}
