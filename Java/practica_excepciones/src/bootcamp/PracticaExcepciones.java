package bootcamp;

public class PracticaExcepciones {

    private static int a = 0;
    private static int b = 300;

    public static void main(String[] args) {
        double cociente;

        try{
            cociente = b/a;
        }catch (ArithmeticException excepcion){
           // System.out.println("Se ha producido un error");

            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }

    }
}
