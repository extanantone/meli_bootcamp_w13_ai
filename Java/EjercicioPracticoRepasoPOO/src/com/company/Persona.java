package com.company;

import java.util.IllegalFormatCodePointException;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura; // centimetros

    public Persona() {

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public double IMC(){
        return peso/(altura*altura);

    }

    public int calcularIMC(){
        double IMC =  peso/(altura*altura);
        if (IMC<20){
            return -1;
        } else {
            return (IMC<=25? 0:1);
        }
    }

    public boolean esMayorEdad(){
        return this.edad>=18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
