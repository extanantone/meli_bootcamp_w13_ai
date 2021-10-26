package bootcamp;

public class PracticaExcepciones {

    private static final int a = 0;
    private static final int b = 300;

    public static void main(String []args ){

//Ejercicio 1 Parte 1
        try {
           int c = b / a;
            //throw new IllegalArgumentException("Se intento dividir por 0 cero");

        } catch (ArithmeticException e) {
            //System.out.println("Se ha producido un error");
            //e.printStackTrace();
            throw new IllegalArgumentException("Se intento dividir por 0 cero");
        }
        finally{
            System.out.println("Programa finalizado");
        }

    }



}
