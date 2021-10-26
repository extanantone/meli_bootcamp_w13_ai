package com.company;

public class Participante {
    private static int id=0;
    private int idPer;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int numeroEmerg;
    private String grupoSanguineo;
    private double valorInscripcion;

    public Participante(int dni, String nombre, String apellido, int edad, int celular, int numeroEmerg, String grupoSanguineo, double valorInscripcion) {
        id++;
        this.idPer = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmerg = numeroEmerg;
        this.grupoSanguineo = grupoSanguineo;
        this.valorInscripcion = valorInscripcion;
    }

    public int getIdPer() {
        return idPer;
    }

    public void setIdPer(int idPer) {
        this.idPer = idPer;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
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

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getNumeroEmerg() {
        return numeroEmerg;
    }

    public void setNumeroEmerg(int numeroEmerg) {
        this.numeroEmerg = numeroEmerg;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public double getValorInscripcion() {
        return valorInscripcion;
    }

    public void setValorInscripcion(double valorInscripcion) {
        this.valorInscripcion = valorInscripcion;
    }
}
