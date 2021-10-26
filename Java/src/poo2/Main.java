package poo2;

public class Main {

    public static void main(String[] args) {

        Ejercicio1 p = new Ejercicio1();

        try {
            System.out.println(p.calcularCociente());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }

    }
}
