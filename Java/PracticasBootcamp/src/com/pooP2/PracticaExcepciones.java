package com.pooP2;

public class PracticaExcepciones {

    public static void main(String[] args) {
        int a =0;
        int b=300;

        try{
            int re = b/a;
        }catch (Exception e){
           // System.out.println("Se producio en Error");
            throw new IllegalArgumentException("No se puede dividir por cero");

        }finally {
            System.out.println("Programa Finalizado");
        }

    }


}
