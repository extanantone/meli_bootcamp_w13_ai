package ejericiciopractico.ejercicio1;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public void calcularCociente(){
        double salida = 0;
        try{
            salida = b/a;
        }catch (ArithmeticException e){
            System.out.println("Se ha producido un error");
        }
        System.out.println("Programa finalizado");
    }

    public void calcularOtroCociente(){
        double salida = 0;
        try{
            salida = b/a;
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir en Cero");
        }
        System.out.println("Programa finalizado");
    }

}
