package com.MELI.models;

public class Participante {
    private int nInscripcion;
    private int dni;
    private String nombre;
    private String apellido;
    private int celular;
    private int edad;
    private long numEmergencia;
    private String factorSanguineo;

    public Participante(int dni, String nombre, String apellido,
                        int cel, int edad, long numEmergencia, String factorSanguineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = cel;
        this.edad = edad;
        this.numEmergencia = numEmergencia;
        this.factorSanguineo = factorSanguineo;
    }

    public Participante() {
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

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getNumEmergencia() {
        return numEmergencia;
    }

    public void setNumEmergencia(long numEmergencia) {
        this.numEmergencia = numEmergencia;
    }

    public String getFactorSanguineo() {
        return factorSanguineo;
    }

    public void setFactorSanguineo(String factorSanguineo) {
        this.factorSanguineo = factorSanguineo;
    }

    public int getnInscripcion() {
        return nInscripcion;
    }

    public void setnInscripcion(int nInscripcion) {
        this.nInscripcion = nInscripcion;
    }

    @Override
    public String toString() {
        return "Participante: " +
                "\n Numero de inscripcion= " + nInscripcion +
                "\n dni=" + dni +
                ", \n nombre='" + nombre + '\'' +
                ", \n apellido='" + apellido + '\'' +
                ", \n celular=" + celular +
                ", \n edad=" + edad +
                ", \n numEmergencia=" + numEmergencia +
                ", \n factorSanguineo='" + factorSanguineo;
    }
}
