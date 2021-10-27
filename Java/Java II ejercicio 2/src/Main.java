public class Main {
     public static void main(String[] args) {

         //// ejercicio 1

         int  a = 0;
         int b = 300;

        try{
           int c = b/a;
         }catch (ArithmeticException exception){
           System.out.println("se ha producido un error");
         }finally {
             System.out.println("programa finalizador");
         };

         try{
             if(a == 0){
                 throw new IllegalArgumentException("No se puede dividir por cero");
             }
         }catch (IllegalArgumentException exception){
             exception.printStackTrace();
         };



    }
}
