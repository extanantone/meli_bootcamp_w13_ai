package poo.p2;

public class PracticasExcepciones {
    public static void main(String[] args) {

        int a = 0;
        int b = 300;

        try{
            float cociente = b/a;
        }
        catch (ArithmeticException e){
            System.out.println("No se puede dividir por cero: "+e.getMessage());
        }
    }
}
