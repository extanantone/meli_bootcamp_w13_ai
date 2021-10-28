package ej2;

public class Main {
    public static void main(String[] args) {
        Persona santiago = new Persona("Santiago", "Acevedo","123123");

        santiago.agregarHabilidad("Node");
        santiago.agregarHabilidad("SQL");

        Curriculum cv = new Curriculum(santiago);

        cv.imprimir();

        Informes informe = new Informes("ESTO ES UN INFORME","Jane","Marco",10);
        informe.imprimir();

        LibrosPDF pdf = new LibrosPDF(30,"Lara","Hallowen","Terror");

        pdf.imprimir();
    }
}
