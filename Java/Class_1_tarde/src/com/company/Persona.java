package com.company;

public class Persona {
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroDeEmergencia;
    private String grupoSanguineo;

    public int getEdad() {
        return edad;
    }

    public Persona(String dni, String nombre, String apellido, int edad, String celular, String numeroDeEmergencia, String grupoSanguineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroDeEmergencia = numeroDeEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }
}
