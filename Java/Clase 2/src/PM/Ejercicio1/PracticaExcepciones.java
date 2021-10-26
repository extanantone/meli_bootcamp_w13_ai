package PM.Ejercicio1;

public class PracticaExcepciones {
    public static final int A = 0;
    public static final int B = 300;

    public double calcularCociente() {
        double cociente = 0;

        try {
            cociente = B / A;
        } catch (ArithmeticException AE) {
//            System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }

        return cociente;
    }
}