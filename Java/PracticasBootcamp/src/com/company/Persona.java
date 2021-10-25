package com.company;

public class Persona {

    private long dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroDeEmergencia;
    private String grupoSanguineo;
    private int numeroParticioante;

    public Persona(long dni, String nombre, String apellido, int edad, String celular, String numeroDeEmergencia, String grupoSanguineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroDeEmergencia = numeroDeEmergencia;
        this.grupoSanguineo = grupoSanguineo;

    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNumeroDeEmergencia() {
        return numeroDeEmergencia;
    }

    public void setNumeroDeEmergencia(String numeroDeEmergencia) {
        this.numeroDeEmergencia = numeroDeEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getNumeroParticioante() {
        return numeroParticioante;
    }

    public void setNumeroParticioante(int numeroParticioante) {
        this.numeroParticioante = numeroParticioante;
    }
}
