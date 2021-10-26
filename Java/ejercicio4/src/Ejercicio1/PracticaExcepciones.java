package Ejercicio1;

public class PracticaExcepciones {
    private static int a = 0;
    private static int b = 300;

    static int dividir(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException a) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public static void main(String[] args) {
        System.out.println(dividir(b, a));
    }
}
