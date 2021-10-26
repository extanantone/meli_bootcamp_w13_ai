package com.mercadolibre.dominio;

public class Persona {
    private String nombre;
    private String apellido;
    private int dni;
    private int edad;
    private double numeroEmergencia;
    private String grupoSanguineo;
    private String categoria;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int dni, int edad, double numeroEmergencia, String grupoSanguineo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public Persona(String nombre, String apellido, int dni, int edad, double numeroEmergencia, String grupoSanguineo, String categoria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.categoria = categoria;
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

    public double getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(double numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return " Nombre: '" + nombre + '\'' +
                ", Apellido: '" + apellido + '\'' +
                ", DNI: " + dni +
                ", Edad: " + edad +
                ", Numero de emergencia: " + numeroEmergencia +
                ", Grupo sanguineo:'" + grupoSanguineo + '\'' +
                ", Categoria maraton: '" + categoria + '\'';
    }
}
