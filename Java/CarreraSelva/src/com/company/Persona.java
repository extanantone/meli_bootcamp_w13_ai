package com.company;

public class Persona {

    int dni;
    String nombre;
    String apellido;
    int edad;
    String celular;
    String numeroEmergencia;
    String grupoSanguineo;
    int inscripcion;

    public Persona(int dni, String nombre, String apellido, int edad, String celular, String numeroEmergencia, String grupoSanguineo, int inscripcion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.inscripcion = inscripcion;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCelular() {
        return celular;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }
}