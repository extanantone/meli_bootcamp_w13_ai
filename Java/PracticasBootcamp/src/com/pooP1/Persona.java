package com.pooP1;

public class Persona {

    private String dni;
    private String nombre;
    private int edad;
    private double peso;
    private double altura;

    public Persona(){}

    public Persona(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(String dni, String nombre, int edad, double peso, double altura) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcular(){

        double resultado;

        resultado =this.peso/(Math.pow(this.altura,2));

        if(resultado<20){
            return -1;
        }else if (resultado <=25){
            return 0;
        }else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){

        if(this.edad < 18){
            return false;
        }else{
            return true;
        }
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
}
