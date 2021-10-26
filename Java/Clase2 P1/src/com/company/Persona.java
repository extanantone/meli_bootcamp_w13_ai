package com.company;

public class Persona {
    String dni;
    String nombre;
    short edad;
    float peso;
    float altura;

    public Persona(String dni, String nombre, short edad, float peso, float altura) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String dni, String nombre, short edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(){

    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }

    public short calcularIMC(){
        float imc = peso / (altura * altura);
        if (imc < 20)
            return -1;
        else if(imc <= 25)
            return 0;
        else
            return 1;
    }

    public boolean esMayorDeEdad(){
        if (edad < 18)
            return false;
        else
            return true;
    }
}
