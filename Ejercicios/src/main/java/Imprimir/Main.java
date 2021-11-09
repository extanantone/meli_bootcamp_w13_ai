package Imprimir;

public class Main {

    public static void main(String[] args) {
        Curriculum cv = new Curriculum();
        cv.imprimir();

        Pdf pdf = new Pdf();
        pdf.imprimir();
    }
}
