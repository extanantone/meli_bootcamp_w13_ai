package com.bootcamp.models;

public class Persona {

    String nombre, dni;
    int edad;
    double peso,altura; //Elijo hacer estas variables con float  //Ejercicio 1



    //Ejercicio 2
    public Persona(){}

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, String dni, int edad, double altura, double peso) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }



    //Ejercicio 5: metodos

    public int calcularIMC(){

        double imc = this.peso/(Math.pow(this.altura,2));

        System.out.println("El IMC de: " + this.nombre + "es de: " + imc);

        if(imc < 20){
            return -1;
        }
        else if(imc >= 20 && imc <=25){
            return 0;
        }
        else
            return 1;

    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    @Override
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
