package Excepciones;

public class PracticaExcepciones {
    public static void main(String[] args) {
        try {
            int a = 0;
            int b = 300;
            int c = b / a;
        } catch (ArithmeticException e) {
System.out.println("Se ha producido un error, no se puede dividir por cero.");
        }finally {
System.out.println("Programa finalizado");
            }
        }
    }