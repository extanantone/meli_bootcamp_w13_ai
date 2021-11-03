package com.example.spring.Deporte.models;

public class Persona {

    private String nombre;
    private String apellido;
    private String deporte;
    private int edad;

    public Persona(String nombre, String apellido, String deporte, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
}
