package com.company;

public class Persona {

    String nombre,dni;
    int edad;
    double peso,altura;

    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona() {
    }

    public Persona(String nombre, String dni, int edad, double peso, double altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC()
    {
        double imc = peso/(altura*altura);

        if (imc<20){
            return -1;
        }
        else {
            if (imc>=20 && imc<25)
            {
                return 0;
            }
            else{
                return 1;
            }
        }
    }

    public boolean esMayorDeEdad(){
        if (edad>=18){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
