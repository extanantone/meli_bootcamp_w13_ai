package com.company.objets;

public class Persona {

    int dni;
    int edad;
    String nombre;
    String apellido;

    public Persona(int dni, int edad, String nombre, String apellido) {
        this.dni = dni;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }
    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
