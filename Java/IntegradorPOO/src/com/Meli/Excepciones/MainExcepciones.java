package com.Meli.Excepciones;

import com.Meli.Excepciones.Entity.PracticaExcepciones;

public class MainExcepciones {

    public static void main(String[] args) {
        PracticaExcepciones pe = new PracticaExcepciones();
        dividir(pe.getA(), pe.getB());
        try{
            double resultado = pe.getB()/pe.getA();
        }
        catch (ArithmeticException ae){
            System.err.println("Se ha producido un error.");
        }
        finally{
            System.out.println("Programa finalizado");
        }
    }

    private static void dividir(int a, int b){

        try{
            if(a==0)
                throw new IllegalArgumentException("No se puede dividir por cero");
        }
        catch (IllegalArgumentException ae){
            ae.printStackTrace();
        }
        finally{
            System.out.println("Programa finalizado");
        }
    }
}
