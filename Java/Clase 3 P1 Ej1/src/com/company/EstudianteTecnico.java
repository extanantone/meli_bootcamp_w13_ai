package com.company;

public class EstudianteTecnico extends Estudiante implements Tecnico{
    public EstudianteTecnico(String nombre, String dni, String idEstudiante, String carrera) {
        super(nombre, dni, idEstudiante, carrera);
    }

    @Override
    public void RevisarComputadoras() {
        System.out.println("El estudiante técnico está revisando las computadores");
    }

    @Override
    public void ArreglarComputadoras() {
        System.out.println("El estudiante técnico está arreglando las computadores");
    }

    @Override
    public void ControlarRedes() {
        System.out.println("El estudiante técnico está controlando las redes");
    }

    @Override
    public void RealizarSetup() {
        System.out.println("El estudiante técnico está realizando el setup");
    }
}
