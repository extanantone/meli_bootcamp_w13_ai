package com.mercadolibre.dominio;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(){}
    public Persona(String nombre, int edad, String dni){
        this.nombre=nombre;
        this.edad=edad;
        this.dni=dni;
    }
    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calculaIMC(){
        double imc = this.peso / Math.pow(this.altura,2);
        int resultado=1;
        if(imc<20){
            return -1;
        } else if (imc>=20 && imc<=25){
            return 0;
        }
        return resultado;
    }
    public boolean esMayorEdad(){
        return this.edad>=18;
        /*boolean esMayor= false;
        if (this.edad>=18){
            esMayor = true;
        }
        return esMayor; */
    }

    @Override
    public String toString() {
        return " Nombre='" + nombre + '\'' +
                ", Edad=" + edad +
                ", DNI='" + dni + '\'' +
                ", Peso=" + peso +
                ", Altura=" + altura;
    }
}
