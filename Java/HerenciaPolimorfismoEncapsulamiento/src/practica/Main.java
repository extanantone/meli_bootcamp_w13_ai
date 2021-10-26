package practica;

public class Main {
    public static void main(String[] args) {
        PracticaExcepciones practica = new PracticaExcepciones();

        try {
            System.out.println(practica.calcularCociente());
        }catch(ArithmeticException e){
            /*System.out.println("Se ha producido un error");*/
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
