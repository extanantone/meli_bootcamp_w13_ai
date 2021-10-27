package com.company;

public class Estudiante extends Persona{
    String idEstudiante;
    String carrera;

    public Estudiante(String nombre, String dni, String idEstudiante, String carrera) {
        super(nombre, dni);
        this.idEstudiante = idEstudiante;
        this.carrera = carrera;
    }
}
