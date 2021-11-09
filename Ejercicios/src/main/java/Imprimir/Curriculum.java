package Imprimir;

public class Curriculum extends Documento {

    Datos datos = new Datos(36291965, "Blenki", "Gomez", "Programadorx");

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo curriculum con los siguientes " + datos);

    }
}
