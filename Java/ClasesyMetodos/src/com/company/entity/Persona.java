package com.company.entity;

public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private float altura;
    private float peso;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
    }

    public Persona(String nombre, int edad, String dni, float altura, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
    }

    public int cacularIMC(){
        int result = 0;
        if(altura>0){
            double imc = this.peso/(Math.pow(this.altura, 2));
            if(imc<20)
                return -1;
            else{
                if(imc>25)
                    return 1;
                else
                    return 0;
            }
        }
        else
            return -2;

    }

    public boolean esMayorDeEdad(){
        if(this.edad>17)
            return true;
        else
            return false;
    }

    @Override
    public String toString(){
        return "DNI: "+this.dni+", \nNombre: "+this.nombre+", \nEdad: "+this.edad+
                ", \nPeso: "+this.peso+", \nAltura: "+this.altura;
    }
}
