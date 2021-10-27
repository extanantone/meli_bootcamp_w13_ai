package com.company;

public class Main {

    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Pedro", "31.231.232", "34", "Analista");
        Persona estudianteTec = new EstudianteTecnico("Paula", "39.123.963", "23", "Tecnica");
        Estudiante estudianteTutor = new Tutor("Dario", "29.312.359", "2", "Ingenieria", "Analista");

        Personal profesor = new Profesor("Gaston", "25.322.943", "9321", "Profesorado ...");
        Persona perMantenmiento = new PersonalMantenimiento("Luis", "29.134.163", "8413", " ...");
        PersonalTecnico perTenico = new PersonalTecnico("Sandre", "27.412.592", "7592", "Tecnica");
    }
}
