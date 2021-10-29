package com.company;

public class Animal {
    String especie;

    public Animal(String especie) {
        this.especie = especie;
    }

    public String getespecie() {
        return especie;
    }

    public void setespecie(String especie) {
        this.especie = especie;
    }

    public void mostrarEspecie() {
        System.out.println("Soy un animal de la especie: " + this.especie);
    }

    public void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }
}
