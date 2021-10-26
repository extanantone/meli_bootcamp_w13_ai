package ejercicio1;

public class PracticaExcepciones {

    public static void main(String[] args) {

        int a = 0;

        int b = 300;

        try {
            if(a==0)
            //throw new ArithmeticException("Se ha producido un error");
                throw new IllegalArgumentException("No se  puede dividir por cero");
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }finally {
            System.out.println("Programa Finalizado");
        }

    }

}
