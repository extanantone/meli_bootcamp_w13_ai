package com.app;

/**
 * Persona
 */
public class Persona {

    String nombre;
    int edad;
    String dni;
    double altura;
    double peso;

    public Persona(){

    }

    public Persona(String nombre,int edad,String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;

    }

    public Persona(String nombre,int edad, String dni,double altura,double peso){
        this.nombre = nombre;
        this.edad = edad;
        this.dni= dni;
        this.altura = altura;
        this.peso = peso;
    }

    public int calcularIMC(){
        double metrica = peso/Math.pow(altura, 2);
        if(metrica<20) return -1;
        else if(metrica<=25) return 0;
        else return 1;
    }

    public boolean esMayorDeEdad(){
        return edad>18;
    }

    @Override
    public String toString() {
        return "\n\nPersona \nnombre: "+nombre+"\nedad: "+edad+"\n"+"dni: "+dni+"\naltura: "+altura+"\ndni: "+dni;
    }
    
}