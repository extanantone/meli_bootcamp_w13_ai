package com.company;

public class Persona{
    int dni;
    String nombre;
    String apellido;
    short edad;
    String celular;
    String nroEmergencia;
    String grupoSanguineo;
    String categoria;

    @Override
    public String toString() {
        return "Persona{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                ", nroEmergencia='" + nroEmergencia + '\'' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    public Persona(int dni, String nombre, String apellido, short edad, String celular, String nroEmergencia, String grupoSanguineo, String categoria){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.nroEmergencia = nroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.categoria = categoria;
    }

    void mostrarDatos(){
        System.out.format("DNI: %d, Nombre: %s, Apellido: %s, Edad: %d, Celular: %s, Emergencia: %s, Grupo Sanguineo: %s", dni, nombre, apellido, edad, celular, nroEmergencia, grupoSanguineo);
    }
}
