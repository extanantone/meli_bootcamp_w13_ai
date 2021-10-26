package com.MELI.entity;

public class Persona {
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private long nroEmergencia;
    private String grupoSangineo;

    public Persona(int dni, String nombre, String apellido, int edad, long nroEmergencia, String grupoSangineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nroEmergencia = nroEmergencia;
        this.grupoSangineo = grupoSangineo;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNroEmergencia(long nroEmergencia) {
        this.nroEmergencia = nroEmergencia;
    }

    public void setGrupoSangineo(String grupoSangineo) {
        this.grupoSangineo = grupoSangineo;
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

    public long getNroEmergencia() {
        return nroEmergencia;
    }

    public String getGrupoSangineo() {
        return grupoSangineo;
    }
}
