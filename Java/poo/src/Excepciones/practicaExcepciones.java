package Excepciones;

import java.util.NoSuchElementException;

public class practicaExcepciones {
    public static void main (String [] args){
        int a =0;
        int b =300;
        try{
            int resultado = b/a;
        }catch(ArithmeticException e){
            System.out.println("No se puede dividir por cero");
        }finally{
            System.out.println("Programa finalizado");
        }
    }
}
