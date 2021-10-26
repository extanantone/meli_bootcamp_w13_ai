package com.company;

public class Persona {
    String nombre, dni;
    int edad, peso;
    double altura;

    public Persona() {}

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, int peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double imc = this.peso / Math.pow(this.altura / 100, 2);

        if (imc < 20) return -1;
        if (imc <= 25) return 0;
        return 1;

    }

    public boolean esMayorDeEdad() {
        return this.edad > 17;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(this.nombre).append(" tiene ")
                .append(this.edad).append(" años, su dni es ").append(this.dni).append(", pesa ")
                .append(this.peso).append(" kgs, y mide ").append(this.altura).append(" cm").toString();
    }

    public void mostrarDatos(){
        System.out.println(this.toString());
    }
}