package com.company;

public class Tutor extends Estudiante implements Enseñante{
    String materia;

    public Tutor(String nombre, String dni, String idEstudiante, String carrera, String materia) {
        super(nombre, dni, idEstudiante, carrera);
        this.materia = materia;
    }

    @Override
    public void Explicar() {
        System.out.println("El tutor está explicando");
    }

    @Override
    public void PreguntarDudas() {
        System.out.println("El tutor está preguntando si hay alguna duda");
    }
}
