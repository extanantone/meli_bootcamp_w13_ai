package Ejercicio2;

public class Main {
    public static void main(String[] args){
        Informe informe= new Informe(
                "Pepe",
                "Aguilar",
                9000,
                10,
                "Hola mundo",
                "Juan Moreno");
        Curriculum curriculum= new Curriculum(
                "Pepe",
                "Aguilar",
                9000,
                10,
                "Hola mundo",
                "Juan Moreno");
        LibroPDF libroPDF= new LibroPDF(
                "Pepe",
                "Aguilar",
                9000,
                10,
                "Hola mundo",
                "Juan Moreno");

        informe.imprimir();
        curriculum.imprimir();
        libroPDF.imprimir();
    }

}
