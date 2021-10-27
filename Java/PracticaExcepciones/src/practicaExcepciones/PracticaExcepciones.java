package practicaExcepciones;

public class PracticaExcepciones {

    static int a = 0;
    static int b = 300;

    public static double calcularCociente() {
        double cociente = 0;
        try {
            cociente = (double) b/a;
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por cero");
        }
        return cociente;
    }
}
