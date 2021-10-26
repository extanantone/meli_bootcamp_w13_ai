package com.company;

public class Persona {

    String nombre;
    int edad;
    String dni;
    int peso;
    double altura;

    public Persona(){

    }

    public Persona(String nombre, int edad, String dni){
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

    public int calcularIMC(){
        double imc = this.peso/(this.altura * this.altura);
        int ret = -1;

        if (imc > 25){
            ret = 1;
        }
        else {
            if(imc > 19){
                ret = 0;
            }
        }
        return(ret);
    }

    public boolean esMayorDeEdad(){
        return(this.edad > 17);
    }

    public String toString(){
        return (this.nombre + " tiene " + this.edad + " años y es identificado por el dni: " + this.dni + ", mide " + this.altura + " metros y pesa " + this.peso + " kilos.");
    }
}
