package com.company;

public class Persona {
    String nombre;
    String edad;
    String dni;
    double peso;
    double altura;

    public Persona() {

    }

    public Persona(String nombre, String edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, String edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }


}
