package com.company;

public class Main {

    public static void main(String[] args) {
        Persona per = new Persona("Pedro");
        per.agregarHabilidad("Pintar");
        per.agregarHabilidad("Correr");
        Imprimible cv = new Curriculum(per);
        Imprimible libro = new LibroPdf("Joaquin", 12, "La dama dorada", "Romantica");
        Imprimible informe = new Informes("Diana", 12, "Luis", 983);

        cv.Imprimir();
        libro.Imprimir();
        informe.Imprimir();
    }
}
